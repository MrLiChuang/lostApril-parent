package com.lostApril.service.register.impl;

import com.lostApril.dao.UserMapper;
import com.lostApril.dto.UserDto;
import com.lostApril.dto.UserRegisteDto;
import com.lostApril.service.register.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lee
 * @Time 2019/12/18 13:59
 */
@Service("userRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    public int registerUser(UserRegisteDto userRegisteDto) {
        return userMapper.addNewUser(userRegisteDto);
    }

    public void activeUser() {

    }

    public boolean checkUserName(String username) {
        UserDto user = userMapper.selectByUsername(username);
        return user == null  ;
    }

    public boolean checkEmail(String email) {
        String user = userMapper.selectByEmail(email);
        return user == null;
    }

}
