package com.example.springboot.controller;

import com.example.springboot.entity.ConfigBean;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suneee on 2018/6/8.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class ConfigController {

    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/love")
    public String love() {
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    private User user;

    @RequestMapping("/user")
    public String user() {
        return user.getName() + user.getAge();
    }
}
