package com.liang.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: Liangxp
 * @Description: 创建一个Spring定义的FactoryBean
 * @date: 2019/6/22 14:42
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("FactoryBean……getObject……" );
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    public boolean isSingleton() {
        return true;
    }
}
