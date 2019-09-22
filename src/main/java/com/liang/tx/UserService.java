package com.liang.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Liangxp
 * @date 2019/6/27 21:17
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert(){
        userDao.insert();
        System.out.println("插入完成.....");
        int a = 20/10;
    }
}
