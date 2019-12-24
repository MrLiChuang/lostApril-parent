package com.lostApril.controller;

import com.lostApril.result.Result;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lee
 * @Time 2019/12/20 13:52
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("")
    public String toLogin(HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            response.sendRedirect("/lostApril/main");
        }
        return "login";
    }

    @RequestMapping("/success")
    @ResponseBody
    public Result successLogin(){
        Result result = new Result();
        result.setSuccess(true);
        return  result;
    }
}
