package com.liang.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author: Liangxp
 * @Description: 自定义逻辑返回需要导入的组件
 * @date: 2019/6/22 14:07
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值，就是到导入到容器中的组件全类名
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        String className = importingClassMetadata.getClassName();
        for (String annotationType : annotationTypes) {
            System.out.println(className+"上面的注解-----》"+annotationType);
        }

        //方法不要返回null值
        return new String[]{"com.liang.entity.Blue","com.liang.entity.Red"};
    }
}
