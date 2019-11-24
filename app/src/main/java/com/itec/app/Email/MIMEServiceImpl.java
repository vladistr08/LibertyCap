package com.itec.app.Email;


import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MIMEServiceImpl {
    public void sendMail(String to, String subject, String text) {
        try {
            JavaMailSenderImpl sender = new JavaMailSenderImpl();

            sender.setHost("smtp.gmail.com");
            sender.setPort(443);
            sender.setUsername("gkandrey1@gmail.com");
            sender.setPassword("gnhtncetoteovmyl");

            Properties mailProp = sender.getJavaMailProperties();
            mailProp.put("mail.transport.protocol", "smtp");
            mailProp.put("mail.smtp.auth", "true");
            mailProp.put("mail.smtp.starttls.enable", "true");
            mailProp.put("mail.smtp.starttls.required", "true");
            mailProp.put("mail.debug", "true");
            mailProp.put("mail.smtp.ssl.enable", "true");
            mailProp.put("mail.smtp.socketFactory.fallback", "true");


            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);

            sender.send(message);
        } catch (MessagingException e) {
            System.out.println(e.getCause());
        }
    }
}
