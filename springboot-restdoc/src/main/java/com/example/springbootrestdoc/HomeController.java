package com.example.springbootrestdoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by suneee on 2018/6/13.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public Map<String, Object> home() {
        return Collections.singletonMap("message", "Hello World");
    }
}
