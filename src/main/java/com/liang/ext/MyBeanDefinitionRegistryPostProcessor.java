package com.liang.ext;

import com.liang.entity.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/7/4 22:21
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量："+registry.getBeanDefinitionCount());

        //注册自己的bean定义信息
        //AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        registry.registerBeanDefinition("hellBlue",beanDefinition);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor.postProcessBeanFactory()执行后...bean的数量:"+beanFactory.getBeanDefinitionCount());
    }
}
