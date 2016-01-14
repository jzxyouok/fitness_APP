package com.jlu.zhu.entity;

/**
 * OssClientVar
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-09-16
 */
public enum OssClientVar {
    ENDPOINT(1, "oss-cn-hangzhou.aliyuncs.com"),
    ACCESSKEYID(2, "V7pzkRmfyYfIkX4c"),
    SECRETACCESSKEY(3, "cJ4QRAwDg4CZbt8MYVXfYJW6gDNKVq"),
    BUCKETNAME(4, "staratlas"),
    FILENAME_IP_LOCATION(5, "ip_location.txt"),
    FILENAME_IP_TYPE(6, "ip_type.txt");

    private Integer type;
    private String value;

    OssClientVar(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer type() {
        return this.type;
    }

    public String value() {
        return this.value;
    }
}
