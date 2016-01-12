package com.jlu.zhu;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * AbstractComponentTest
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-11-23
 */
//此处加载的是test/resources/spring.xml,若存在。若此路径下不存在，则调用classpath下的，若classpath下没有，则报错。且可以加载多个配置文件，中间用，隔开。
@ContextConfiguration(locations = {"classpath:spring.xml"})
public abstract class AbstractComponentTest extends AbstractTestNGSpringContextTests {
/*    @BeforeClass
    public void before() throws Exception {
        AbstractScheduledService.Scheduler scheduler = SpringContextHolder.getBean("auditSchedulerFactoryBean");
        String[] groupNames = scheduler.getTriggerGroupNames();
        for (String groupName : groupNames) {
            String[] jobNames = scheduler.getJobNames(groupName);
            for (String jobName : jobNames) {
                scheduler.deleteJob(jobName, groupName);
            }
        }
    }*/

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        // invoke prepareAll and prepare{method.name}
        Class<?> cla = this.getClass();
        try {
            Method prepareAllMethod = cla.getMethod("prepareAll");
            prepareAllMethod.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：prepareAll");
        }
        try {
            Method prepareTestMethod = cla.getMethod("prepare" + method.getName().substring(4));
            prepareTestMethod.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：prepare" + method.getName().substring(4));
        }
    }

    @AfterMethod
    public void afterMethod(Method method) throws Exception {
        Class<?> cla = this.getClass();
        try {
            Method clearX = cla.getMethod("clear" + method.getName().substring(4));
            clearX.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：clearAll");
        }
        try {
            Method clearAll = cla.getMethod("clearAll");
            clearAll.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：clearAll");
        }
    }

}

