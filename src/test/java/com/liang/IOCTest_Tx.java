package com.liang;

import com.liang.tx.TxConfig;
import com.liang.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Liangxp
 * @date 2019/6/27 21:31
 */
public class IOCTest_Tx {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();
    }
}
