package com.lostApril.dto;

import java.io.Serializable;

/**
 * @author Lee
 * @Time 2019/12/17 17:47
 */
public class UserRegisteDto implements Serializable {

    private String username;

    private String password;

    private String email;

    private int status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
