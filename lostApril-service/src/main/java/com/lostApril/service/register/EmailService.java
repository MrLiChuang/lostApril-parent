package com.lostApril.service.register;

/**
 * @author Lee
 * @Time 2019/12/17 15:51
 */
public interface EmailService {

    boolean emailActiveCodeSendAndStore(String email);

    boolean emailActiveCodeRecheck(String email, String activeCode);

}
