package com.lostApril.service.register.impl;

import com.lostApril.service.register.EmailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Lee
 * @Time 2019/12/17 15:53
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private JavaMailSender javaMailSender;

    private String subject;
    private final String mailFrom = "lost_april@163.com";

    public boolean emailActiveCodeSendAndStore(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String emailActiveCode = RandomStringUtils.randomNumeric(6);
        StringBuilder content = new StringBuilder();
        redisTemplate.opsForValue().set(email,emailActiveCode,10,TimeUnit.MINUTES);
        subject="[LostApril.com] 验证您的注册("+emailActiveCode+")";
        message.setSubject(subject);
        message.setFrom(mailFrom);
        message.setTo(email);
        content.append("尊敬的客户，\n" +
                "感谢您选择LostApril。\n" +
                "本次请求的验证码为：");
        content.append(emailActiveCode);
        content.append("\n此验证码10分钟内有效");
        content.append("\n致敬，\n" +
                "LostApril");
        message.setText(content.toString());

        try {
            javaMailSender.send(message);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean emailActiveCodeRecheck(String email, String emailActiveCode) {
        String emailActiveCodeStored = redisTemplate.opsForValue().get(email);
        return emailActiveCode.equals(emailActiveCodeStored);
    }
}
