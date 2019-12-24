package com.lostApril.authentication.loginHandler;

import com.lostApril.authentication.exception.UserStatusException;
import com.lostApril.authentication.exception.WrongPasswordException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Lee
 * @Time 2019/12/20 15:09
 */
public class UserLoginAuthentication extends DaoAuthenticationProvider {

    private SaltSource saltSource;
    private PlaintextPasswordEncoder plaintextPasswordEncoder;

    public UserLoginAuthentication(UserDetailsService userDetailsService){
        super();
        this.setUserDetailsService(userDetailsService);
        plaintextPasswordEncoder = new PlaintextPasswordEncoder();
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        Object salt = null;
        if (this.saltSource != null) {
            salt = this.saltSource.getSalt(userDetails);
        }
        String presentedPassword = authentication.getCredentials().toString();

        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        } else {
            if (!this.plaintextPasswordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
                throw new WrongPasswordException("密码错误");
            }
            if(!userDetails.isEnabled()){
                throw new UserStatusException("用户未激活");
            }
        }
    }

}
