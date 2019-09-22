package com.liang.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Liangxp
 * 用实现InitializingBean，DisposableBean接口的方式来测试bean的生命周期
 * @date 2019/6/22 16:10
 */
@Component
public class Cat implements InitializingBean,DisposableBean {
    public Cat() {
        System.out.println("Cat.....>constructor.........");
    }

    //相当于初始化方法，在构造函数之后调用
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat......>afterPropertiesSet.......");
    }

    //销毁方法
    public void destroy() throws Exception {
        System.out.println("Cat......>destory.....");
    }

}
