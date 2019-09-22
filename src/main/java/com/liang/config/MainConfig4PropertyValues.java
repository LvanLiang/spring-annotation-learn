package com.liang.config;

import com.liang.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * bean属性注入配置
 * @author Liangxp
 * @date 2019/6/22 18:54
 */
@Configuration
@PropertySource(value={"classpath:/person.properties"})

/**
 * 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;
 * 加载完外部的配置文件以后使用${}取出配置文件的值
 */
public class MainConfig4PropertyValues {
    @Bean
    public Person person(){
        return new Person();
    }
}
