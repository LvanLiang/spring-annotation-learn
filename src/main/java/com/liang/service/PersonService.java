package com.liang.service;

import com.liang.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liangxp
 * @date 2019/6/22 10:40
 */
@Service
public class PersonService {

    //@Qualifier("personMapper2")
    @Autowired
    private PersonMapper personMapper;

    public void print(){
        System.out.println(personMapper);
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personMapper=" + personMapper +
                '}';
    }
}
