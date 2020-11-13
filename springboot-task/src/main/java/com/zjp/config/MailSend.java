package com.zjp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class MailSend {

    @Autowired
    private static JavaMailSenderImpl javaMailSender;

    /**
     *
     * @param subject       主题
     * @param text          正文 （可以解析html）
     * @param fileName      文件名称
     * @param filePath      文件路径
     * @param toMail        发送邮箱地址
     * @param fromMail      接收邮箱地址
     */
    public static void sendMail(String subject, @Nullable String text,
                                @Nullable String fileName,  @Nullable String filePath,
                                String toMail, String fromMail){
        if(!StringUtils.isEmpty(subject) && !StringUtils.isEmpty(toMail)
                && !StringUtils.isEmpty(fromMail)){
            try {
                // 一个复杂的邮件
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                // 组装
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true, "utf-8");
                // 正文
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);

                //附件
                mimeMessageHelper.addAttachment(fileName, new File(filePath));
                mimeMessageHelper.setTo(toMail);
                mimeMessageHelper.setFrom(fromMail);
                javaMailSender.send(mimeMessage);
            }catch (MessagingException e){
                e.printStackTrace();
            }
        }

    }
}
