package com.liang.config;

import com.liang.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author: Liangxp
 * @Description: 配置类==配置文件
 * @date: 2019/6/22 10:32
 */
@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.liang",includeFilters = {
/*        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,Service.class}),
        @ComponentScan.Filter(type =FilterType.ASSIGNABLE_TYPE,classes = {PersonMapper.class},*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyFilterType.class})
},useDefaultFilters = false)

//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {

    //相当于是beans.xml文件里面配置了一个person
    @Bean
    public Person person(){
        return new Person();
    }
}
