package com.lostApril.service.register;

import com.lostApril.dto.UserRegisteDto;

/**
 * @author Lee
 * @Time 2019/12/18 13:57
 */
public interface UserRegisterService {

    int registerUser(UserRegisteDto userRegisteDto);

    void activeUser();

    boolean checkUserName(String username);

    boolean checkEmail(String email);
}
