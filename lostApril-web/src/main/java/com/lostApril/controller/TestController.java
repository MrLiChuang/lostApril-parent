package com.lostApril.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lostApril")
public class TestController {

    @RequestMapping("/main")
    public String main(){

        return "main";
    }
    @RequestMapping("/admin")
    public String admin(){

        return "admin/admin";
    }
    @RequestMapping("/user")
    public String user(){

        return "user/user";
    }
    @RequestMapping("/error")
    public String error(){

        return "error";
    }
 }
