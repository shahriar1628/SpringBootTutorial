package com.springBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName ;

    @Value("helloWorld")
    String hello ;
    @Value("${spring.thymeleaf.prefix}")
    String classPath;
    @GetMapping("/")
    public String homepage(Model model){
        System.out.println(classPath + "   " + hello);
        model.addAttribute("appName ", appName);
        return "home" ;

    }
}
