package com.ustc.reed.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SpringMailUtil {
    private static Logger logger = LoggerFactory.getLogger(SpringMailUtil.class);





    @Autowired
    private JavaMailSender javaMailSender;

//    @Autowired
//    private SimpleMailMessage simpleMailMessage;





    /**
     * 送邮件，同步发送(直接将content做为邮件内容发送出去)
     *
     * @param receivers 收件人
     * @param ccs 抄送人
     * @param title 邮件标题
     * @param content 邮件内容
     */
    public void sendMailByText(String[] receivers, String[] ccs, String title, String content) {
     //   msg = javaMailSender.createMimeMessage();

        try {
            MimeMessage msg  = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg,true);
            msgHelper.setTo(receivers);
            if (ccs != null && ccs.length > 0) {
                msgHelper.setCc(ccs);
            }
            msgHelper.setFrom("m18915228146@163.com");
            msgHelper.setSubject(title);
            msgHelper.setText(content);

            // 发送邮件
            javaMailSender.send(msg);
            logger.info("发邮件");
        } catch (MessagingException e) {
            logger.error("MessagingException", e);
        }

    }
}
