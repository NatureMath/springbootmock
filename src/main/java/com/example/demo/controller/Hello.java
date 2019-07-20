package com.example.demo.controller;

/**
 * @Author huct
 * @Date 2019/7/20 - 8:34
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 @ResponseBody
 @Controller**/
@RestController
public class Hello {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "===========Hello,World2222 dev";
    }
}

