package com.lostApril.authentication.loginHandler;

import com.lostApril.dao.UserMapper;
import com.lostApril.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Lee
 * @Time 2019/12/16 16:20
 */
public class UserLoginAuthInfo implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto re=userMapper.selectByUsername(username);
        User user;
        if ( re.getStatus() == 0)
            user = new User(re.getUsername(), re.getPassword(),false,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(re.getRoles()));
        else
            user = new User(re.getUsername(), re.getPassword(),true,true,true,true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(re.getRoles()));

        return user;
    }
}
