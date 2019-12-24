package com.lostApril.result;

import java.io.Serializable;

/**
 * @author Lee
 * @Time 2019/12/19 16:13
 */
public class Result implements Serializable {

    private boolean success;

    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
