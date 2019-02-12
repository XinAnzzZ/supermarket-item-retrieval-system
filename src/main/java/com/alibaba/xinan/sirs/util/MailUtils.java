package com.alibaba.xinan.sirs.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author XinAnzzZ
 * @date 2019/1/2 11:08
 */
@Component
@Slf4j
public class MailUtils {

    @Autowired
    private JavaMailSender sender;

    private final String from = "13023195022@163.com";

    /**
     * 发送普通邮件
     *
     * @param to      to
     * @param subject the subject
     * @param content the content
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        sender.send(message);
    }

    /**
     * 发送 html 邮件
     *
     * @param to      to
     * @param subject subject
     * @param content the content
     */
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            sender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("邮件发送失败！");
        }
    }
}