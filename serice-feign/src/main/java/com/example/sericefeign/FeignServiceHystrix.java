package com.example.sericefeign;

import org.springframework.stereotype.Component;

/**
 * Created by suneee on 2018/6/1.
 */

@Component
public class FeignServiceHystrix implements FeignService {

    @Override
    public String hi(String name) {
        return "sorry "+name;
    }
}
