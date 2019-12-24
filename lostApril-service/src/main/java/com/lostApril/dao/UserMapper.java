package com.lostApril.dao;

import com.lostApril.dmo.User;
import com.lostApril.dto.UserDto;
import com.lostApril.dto.UserRegisteDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserDto selectByUsername(String username);

    int addNewUser(UserRegisteDto userRegisteDto);

    String selectByEmail(String email);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}