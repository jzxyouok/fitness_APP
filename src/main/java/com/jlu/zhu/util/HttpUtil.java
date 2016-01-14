package com.jlu.zhu.util;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpUtil
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-07-22
 */
public class HttpUtil {
    private static Logger LOG = LoggerFactory.getLogger(HttpUtil.class);
    private static MultiThreadedHttpConnectionManager CONNECTION_MANAGER = new MultiThreadedHttpConnectionManager();
    private static HttpClient HTTP_CLIENT = new HttpClient(CONNECTION_MANAGER);

    static {
        CONNECTION_MANAGER.getParams().setDefaultMaxConnectionsPerHost(50);
        CONNECTION_MANAGER.getParams().setMaxTotalConnections(500);
        CONNECTION_MANAGER.getParams().setStaleCheckingEnabled(true);
        CONNECTION_MANAGER.getParams().setConnectionTimeout(5000);
        HTTP_CLIENT.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));// 不重试
    }

    public static class HttpResponse {
        public static final int SUCCESS_STATUS = 200;

        private int status;
        private HttpMethodBase method;

        public HttpResponse(int status, HttpMethodBase method) {
            this.status = status;
            this.method = method;
        }

        public int getStatus() {
            return status;
        }

        public String getContentAsString() {
            if (status == 200) {
                try {
                    return method.getResponseBodyAsString();
                } catch (IOException e) {
                    LOG.error("http request failure", e);
                }
            }
            return null;
        }
    }

    public static HttpResponse post(String url, Map<String, Object> params) throws IOException {
        List<NameValuePair> nameValues = new ArrayList<NameValuePair>();
        if (params != null) {
            for (String key : params.keySet()) {
                Object value = params.get(key);
                if (value != null) {
                    nameValues.add(new NameValuePair(key, String.valueOf(value)));
                }
            }
        }
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        postMethod.setRequestBody(nameValues.toArray(new NameValuePair[nameValues.size()]));

        int status = HTTP_CLIENT.executeMethod(postMethod);
        return new HttpResponse(status, postMethod);
    }

    public static HttpResponse get(String url, Map<String, Object> params) throws IOException {
        HttpMethodParams methodParams = new HttpMethodParams();
        if (params != null) {
            for (String key : params.keySet()) {
                Object value = params.get(key);
                if (value != null) {
                    methodParams.setParameter(key, value);
                }
            }
        }

        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        getMethod.setParams(methodParams);

        int status = HTTP_CLIENT.executeMethod(getMethod);
        return new HttpResponse(status, getMethod);
    }
}
