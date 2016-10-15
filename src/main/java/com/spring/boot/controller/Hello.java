package com.spring.boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

@RestController
public class Hello {

    @RequestMapping("helloJSP")
    public ModelAndView helloJSP() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HelloPage");
        return modelAndView;
    }

    @RequestMapping("hello")
    public String sayHello() {
        return "Plain text hello";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ModelAndView doGenerate(Model model) {
        model.addAttribute("filename", "test");
        model.addAttribute("test", "test");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
