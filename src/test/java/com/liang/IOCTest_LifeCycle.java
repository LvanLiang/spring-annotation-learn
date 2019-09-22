package com.liang;

import com.liang.config.MainConfig3LifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liangxp
 * @date 2019/6/22 16:04
 */
public class IOCTest_LifeCycle {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3LifeCycle.class);
        System.out.println("spring 容器初始化完成.....");
        Object car = applicationContext.getBean("car");
        applicationContext.close();
    }


}
