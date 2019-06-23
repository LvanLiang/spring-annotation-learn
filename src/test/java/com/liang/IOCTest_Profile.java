package com.liang;

import com.liang.config.MainConfig6Profile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/6/23 15:57
 */
public class IOCTest_Profile {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig6Profile.class);
        System.out.println("spring容器初始化完成......");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("已经注册到容器的bean："+beanDefinitionName);
        }
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean);
    }


    public void test2(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig6Profile.class);
        applicationContext.getEnvironment().setActiveProfiles("prod");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("已经注册到容器的bean："+beanDefinitionName);
        }
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean);
    }
}
