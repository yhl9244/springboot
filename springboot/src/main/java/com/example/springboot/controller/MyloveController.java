package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suneee on 2018/6/8.
 */
@RestController
public class MyloveController {

    @Value("${mylove.name}")
    private String name;

    @Value("${mylove.age}")
    private int age;

    @RequestMapping("/mylove")
    public String mylove() {
        return "mylove is name:" + name + ",age:" + age;
    }
}
