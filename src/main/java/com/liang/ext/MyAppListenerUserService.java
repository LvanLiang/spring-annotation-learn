package com.liang.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Liangxp
 *
 * @date 2019/7/4 22:05
 */
@Service
public class MyAppListenerUserService {

    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("userService监听到的事件："+event);
    }
}
