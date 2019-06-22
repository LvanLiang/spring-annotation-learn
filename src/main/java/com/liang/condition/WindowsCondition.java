package com.liang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author: Liangxp
 * @Description: 判断是否是windows系统
 * @date: 2019/6/22 11:39
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");

        System.out.println("osName------>"+osName);

        if (osName.contains("Windows")){
            return true;
        }
        return false;
    }
}
