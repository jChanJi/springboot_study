package com.chanji.girl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Controller配合模板使用
@Controller
public class HelloController2 {
    @GetMapping("/hello3")
    public String sayhello(){
        return "index";
    }
}
