package com.liang;

import com.liang.aop.MatchCalculator;
import com.liang.config.MainConfig7Aop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: Liangxp
 * @Date: 2019-06-24 15:45
 */
public class IOCTest_AOP {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig7Aop.class);
        MatchCalculator calculator = applicationContext.getBean(MatchCalculator.class);
        System.out.println(calculator.div(1,1));
        applicationContext.close();
    }
}
