package com.example.bloggingPlatform.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final org.springframework.mail.javamail.JavaMailSender ms;
    public EmailService(org.springframework.mail.javamail.JavaMailSender ms){
        this.ms = ms;
    }

    @Async
    public void send(String to,String sub,String text){
        org.springframework.mail.SimpleMailMessage m = new org.springframework.mail.SimpleMailMessage();
        m.setTo(to);
        m.setSubject(sub);
        m.setText(text);
        ms.send(m);
    }
}
