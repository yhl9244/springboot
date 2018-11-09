package com.example.sericefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by suneee on 2018/6/1.
 */

@FeignClient(value = "service-hi", fallback = FeignServiceHystrix.class)
public interface FeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("name") String name);

}
