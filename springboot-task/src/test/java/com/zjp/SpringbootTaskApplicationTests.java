package com.zjp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("zzz,你好");
        simpleMailMessage.setText("谢谢你的课程");
        simpleMailMessage.setTo("906030149zhao@gmail.com");
        simpleMailMessage.setFrom("906030149@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true, "utf-8");
        // 正文
        mimeMessageHelper.setSubject("zzz,你好~plus");
        mimeMessageHelper.setText("<p style='color:red;'>谢谢你的课程</p>", true);

        //附件
        mimeMessageHelper.addAttachment("1.png", new File("C:\\Users\\Zjp\\Desktop\\1.png"));
        mimeMessageHelper.setTo("906030149@qq.com");
        mimeMessageHelper.setFrom("906030149@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
