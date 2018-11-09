package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suneee on 2018/7/24.
 */
@Controller
public class DemoController {

    @RequestMapping("/demo")
    public ModelAndView demo(){
        //[[22, 26, 21],[-71, 38, 21]]
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(22);
        integers1.add(26);
        integers1.add(21);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(-71);
        integers2.add(38);
        integers2.add(21);
        List<List<Integer>> list = new ArrayList<>();
        list.add(integers1);
        list.add(integers2);
        ModelAndView view = new ModelAndView();
        view.setViewName("demo");
        System.out.println(list);
        view.addObject("list",list);
        return view;
    }
}
