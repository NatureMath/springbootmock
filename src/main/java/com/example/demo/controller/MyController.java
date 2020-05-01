package com.example.demo.controller;

import com.example.demo.dto.Person;
import com.example.demo.service.MyService;
import com.example.demo.service.impl.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huct
 * @Date 2019/7/20 - 8:56
 */
/**
 @ResponseBody
 @Controller**/
@RestController
public class MyController {

    @Autowired
    MyService myService;
    @RequestMapping(value = "/my")
    public Person getPer(){
        return myService.queryPer();
    }

    public String getstrf(){
        return MyServiceImpl.getStr();
    }

    public String testPrivate(){
        return myService.testPri();
    }
}

