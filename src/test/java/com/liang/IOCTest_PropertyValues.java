package com.liang;

import com.liang.config.MainConfig4PropertyValues;
import com.liang.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liangxp
 * @date 2019/6/23 13:54
 */
public class IOCTest_PropertyValues {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig4PropertyValues.class);

        System.out.println("spring 容器初始化完成........");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }
}
