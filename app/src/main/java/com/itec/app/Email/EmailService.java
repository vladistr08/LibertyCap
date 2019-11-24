package com.itec.app.Email;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}
