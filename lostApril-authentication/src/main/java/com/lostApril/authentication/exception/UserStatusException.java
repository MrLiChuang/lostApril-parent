package com.lostApril.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Lee
 * @Time 2019/12/20 16:10
 */
public class UserStatusException extends AuthenticationException {

    public UserStatusException(String msg) {
        super(msg);
    }

    public UserStatusException(String msg, Throwable t) {
        super(msg, t);
    }

}
