package com.example.sericefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suneee on 2018/6/1.
 */

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam("name") String name){
        return feignService.hi(name);
    }
}
