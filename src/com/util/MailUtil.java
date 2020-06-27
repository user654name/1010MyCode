package com.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtil {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        sendEmail("719704333@qq.com", "拓", "拓明芬是猪");
        sendEmail("719704333@qq.com", "明", "拓明芬是猪");
        sendEmail("719704333@qq.com", "芬", "拓明芬是猪");
        sendEmail("719704333@qq.com", "是", "拓明芬是猪");
        sendEmail("719704333@qq.com", "猪", "拓明芬是猪");
        return;
    }

    public static void sendEmail(String sendTo, String subject, String content, boolean debug) throws GeneralSecurityException, MessagingException {


        String from = "ztqztq@qq.com";
        String server = "ztqztq@qq.com";

        // 16位授权码
        String password = "tsqjlcjtehrzbjbh";
        //创建一个配置文件并保存
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ztqztq@qq.com", password);
            }
        });

        //开启debug模式
        session.setDebug(debug);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com", server, password);

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress(from));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

        //邮件标题
        mimeMessage.setSubject(subject);

        //邮件内容
        mimeMessage.setContent(content, "text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
    }

    public static void sendEmail(String sendTo, String subject, String content) throws GeneralSecurityException, MessagingException {
        sendEmail(sendTo, subject, content, Boolean.FALSE);
    }
}
