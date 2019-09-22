package com.liang.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Liangxp
 * 使用JSR250中@PostConstruct和@PreDestroy注解来控制bean生命周期
 * @date 2019/6/22 16:17
 */
@Component
public class Dog implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Dog() {
        System.out.println("Dog-------->constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog-------->@PostConstruct");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Dog-------->@PreDestroy");
    }

    /**
     * 获取spring容器对象
     *      ApplicationContextAwareProcessor是BeanPostProcessor后置处理器接口的实现类
     *      invokeAwareInterfaces方法会判断是否是ApplicationContextAware实例然后注入容器对象
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
