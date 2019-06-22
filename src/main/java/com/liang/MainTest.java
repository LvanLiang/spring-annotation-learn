package com.liang;

import com.liang.config.MainConfig2;
import com.liang.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/6/22 10:26
 */
public class MainTest {
    public static void main(String[] args) {

       /*
        使用传统的xml配置的方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("spring 容器初始化完成");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        */


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("spring 容器初始化完成");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);


        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("exist bean："+beanDefinitionName);
        }

        ((AnnotationConfigApplicationContext) applicationContext).close();

    }
}
