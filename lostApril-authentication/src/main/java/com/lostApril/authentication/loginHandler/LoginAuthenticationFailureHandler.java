package com.lostApril.authentication.loginHandler;

import com.lostApril.authentication.exception.UserStatusException;
import com.lostApril.authentication.exception.WrongPasswordException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lee
 * @Time 2019/12/20 15:15
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        if (e.getClass().equals(WrongPasswordException.class)){
            httpServletResponse.sendRedirect("/error/wrongPassword");
        }
        if(e.getClass().equals(UserStatusException.class)){
            httpServletResponse.sendRedirect("/error/wrongStatus");
        }
        if(e.getClass().equals(DisabledException.class)){
            httpServletResponse.sendRedirect("/error/wrongStatus");
        }
    }

}
