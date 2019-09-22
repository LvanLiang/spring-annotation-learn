package com.liang;

import com.liang.config.MainConfig5Autowired;
import com.liang.entity.Boss;
import com.liang.entity.Color;
import com.liang.mapper.PersonMapper;
import com.liang.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liangxp
 * @date 2019/6/23 14:18
 */
public class IOCTest_Autowired {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig5Autowired.class);
        System.out.println("spring容器初始化完成.......");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("注册到容器的bean："+beanDefinitionName);
        }

        //默认按照类型去获取，如果找到多个匹配的，
        //再将属性的名称作为组件的id去容器中查找applicationContext.getBean("personMapper")
        PersonService personService = applicationContext.getBean(PersonService.class);
        personService.print();

        PersonMapper personMapper = (PersonMapper)applicationContext.getBean("personMapper");
        System.out.println(personMapper);



        //@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);


        //构造器注入
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        System.out.println("初始化的ioc容器："+applicationContext);
    }
}
