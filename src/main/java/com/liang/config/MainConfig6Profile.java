package com.liang.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author: Liangxp
 * @Description: @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *                        1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 *                        2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *                        3）、没有标注环境标识的bean在，任何环境下都是加载的；
 * @date: 2019/6/23 15:55
 */
@Configuration
@PropertySource({"classpath:/db.properties"})
public class MainConfig6Profile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    @Value("${db.jdbcUrl}")
    private String jdbcUrl;

    private String driverClass;


    @Profile("test")
    @Bean("testDataSource")
    public DataSource testDataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource devDataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource prodDataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String driverClass = resolver.resolveStringValue("${db.driverClass}");
        this.driverClass = driverClass;
    }
}
