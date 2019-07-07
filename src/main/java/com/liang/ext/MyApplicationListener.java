package com.liang.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description: @Component，@Repository和@Service注释有什么区别 https://www.javaroad.cn/articles/1693
 * @Author: Liangxp
 * @Date: 2019-07-03 10:20
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    //当容器中发布ApplicationEvent事件以后，此方法触发
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件："+event);
    }
}
