package com.liang;

import com.liang.ext.ExtConfig;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liangxp
 * @date 2019-07-03 11:13
 */
public class IOCTest_Ext {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        //自己发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String()) {
            @Override
            public java.lang.String toString() {
                return "我发布的事件";
            }
        });
        applicationContext.close();
    }
}
