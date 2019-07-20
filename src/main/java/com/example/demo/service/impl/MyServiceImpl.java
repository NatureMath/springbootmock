package com.example.demo.service.impl;

import com.example.demo.dto.Person;
import com.example.demo.sao.MySao;
import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author huct
 * @Date 2019/7/20 - 8:54
 */
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    MySao mySao;

    @Override
    public Person queryPer() {
        return mySao.findPer();
    }
}
