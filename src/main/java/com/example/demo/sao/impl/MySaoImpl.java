package com.example.demo.sao.impl;

import com.example.demo.dto.Person;
import com.example.demo.sao.MySao;
import org.springframework.stereotype.Component;

/**
 * @Author huct
 * @Date 2019/7/20 - 8:51
 */

@Component
public class MySaoImpl implements MySao {
    @Override
    public Person findPer() {
        return new Person("dofindPer");
    }
}
