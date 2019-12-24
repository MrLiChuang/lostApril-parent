package com.lostApril.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Lee
 * @Time 2019/12/20 16:17
 */
public class WrongPasswordException extends AuthenticationException {

    public WrongPasswordException(String msg) {
        super(msg);
    }

    public WrongPasswordException(String msg, Throwable t) {
        super(msg, t);
    }

}