package com.shi.wasteManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("hello")
    public String helloController(){
        return "Home";
    }
}
