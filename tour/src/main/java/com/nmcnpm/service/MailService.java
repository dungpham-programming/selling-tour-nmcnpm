package com.nmcnpm.service;

import com.nmcnpm.model.OrderTour;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailService {
    public boolean send(String to, String subject, String messageContent) {
        try {
            // Get properties object
            Properties props = new Properties();
            props.put("mail.smtp.auth", MailProperties.auth);
            props.put("mail.smtp.starttls.enable", MailProperties.ssl);
            props.put("mail.smtp.host", MailProperties.host);
            props.put("mail.smtp.port", MailProperties.port);

            // get Session
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(MailProperties.username, MailProperties.password);
                        }
                    });

            // compose message
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(MailProperties.username, "Hand Made Store"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
//            Vì bold bằng html nên thay vì setText thì setsetContent bên dưới
//            message.setText(messageContent);
            // Thiết lập nội dung là HTML
            message.setContent(messageContent, "text/html; charset=utf-8");
            // send message
            Transport.send(message);
            return true;
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendNotifyPayment(String to, OrderTour orderTour) {
        MailService emailService = new MailService();
        emailService.send(to,
                "Thông báo Tour",
                "Bạn đã thanh toán thành công!" +
                        "<br> Vui lòng liên hệ với chúng tôi nếu bạn có thêm bất kỳ câu hỏi nào hoặc " +
                        "cần hỗ trợ . " +
                        "Chúng tôi đánh giá cao sự hỗ trợ của bạn và mong được phục vụ bạn trong tương lai." +
                        "<br><strong>Tour</strong>");
    }

    public static void main(String[] args) {
        MailService emailService = new MailService();
        emailService.send("lungbaphe772003@gmail.com","test","hehe");
    }
}