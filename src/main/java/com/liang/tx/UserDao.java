package com.liang.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/6/27 21:10
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(){
        String sql = "insert into users(id,name,age) values(?,?,?)";
        String username = UUID.randomUUID().toString().substring(1, 5);
        int update = jdbcTemplate.update(sql, 5, username, 45);
        return update;
    }
}
