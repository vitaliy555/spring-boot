package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Hello {

    @RequestMapping("hello")
    public String sayHello(){
        return "Hello";
    }
}
