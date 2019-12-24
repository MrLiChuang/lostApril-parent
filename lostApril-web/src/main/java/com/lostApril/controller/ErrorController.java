package com.lostApril.controller;

import com.lostApril.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee
 * @Time 2019/12/20 16:21
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/wrongStatus")
    @ResponseBody
    public Result wrongStatus(){
        Result result = new Result();
        result.setSuccess(false);
        result.setErrorMessage("用户尚未激活");
        return result;
    }

    @RequestMapping("/wrongPassword")
    @ResponseBody
    public Result wrongPassword(){
        Result result = new Result();
        result.setSuccess(false);
        result.setErrorMessage("密码错误");
        return result;
    }

}
