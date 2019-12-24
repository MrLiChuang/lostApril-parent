package com.lostApril.controller;

import com.lostApril.result.*;
import com.lostApril.dto.UserRegisteDto;
import com.lostApril.service.register.EmailService;
import com.lostApril.service.register.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee
 * @Time 2019/12/20 11:18
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private EmailService emailService;

    @RequestMapping("")
    public String toRegister(){
        return "register";
    }


    @RequestMapping("/usernameCheck")
    @ResponseBody
    public UserNameCheckResult userNameCheck(@RequestParam String username){
        UserNameCheckResult result = new UserNameCheckResult();
        result.setSuccess(userRegisterService.checkUserName(username));
        return result;
    }

    @RequestMapping("/emailCheck")
    @ResponseBody
    public EmailCheckResult emailCheck(@RequestParam String email){
        EmailCheckResult result = new EmailCheckResult();
        result.setSuccess(userRegisterService.checkEmail(email));
        return result;
    }

    @RequestMapping(value = "/doRegister" , method = RequestMethod.POST)
    @ResponseBody
    public RegisterResult doRegister(UserRegisteDto userRegisteDto){
        RegisterResult result = new RegisterResult();
        int status = userRegisterService.registerUser(userRegisteDto);
        if(status ==1){
            result.setSuccess(true);
        }else
            result.setSuccess(false);

        return result;
    }

    @RequestMapping(value = "/getEmailActiveCode" , method = RequestMethod.POST)
    @ResponseBody
    public EmailCodeSendResult getEmailActiveCode(@RequestParam String email){
        EmailCodeSendResult result = new EmailCodeSendResult();
        result.setSuccess(emailService.emailActiveCodeSendAndStore(email));
        return result;
    }

    @RequestMapping(value = "/confirmEmailActiveCode" , method = RequestMethod.POST)
    @ResponseBody
    public EmailCodeConfirmResult confirmEmailActiveCode(@RequestParam String email, @RequestParam String activeCode){
        EmailCodeConfirmResult result = new EmailCodeConfirmResult();
        result.setSuccess(emailService.emailActiveCodeRecheck(email,activeCode));
        return result;
    }


}
