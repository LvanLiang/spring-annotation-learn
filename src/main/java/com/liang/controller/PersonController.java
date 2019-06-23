package com.liang.controller;

import com.liang.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/6/22 10:43
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

}
