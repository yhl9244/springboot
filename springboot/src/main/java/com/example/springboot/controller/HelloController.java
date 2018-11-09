package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suneee on 2018/6/8.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greeting from spring boot!";
    }
}
