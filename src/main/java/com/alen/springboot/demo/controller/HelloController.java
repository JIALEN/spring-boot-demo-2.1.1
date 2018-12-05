package com.alen.springboot.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author alen
 * @create 2018-12-02 15:42
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hell99 World";
    }

    @RequestMapping("/index")
    public String index(@RequestParam String name) {
       if(StringUtils.isEmpty(name)){
           name="alen";
       }
       return name;
    }



}
