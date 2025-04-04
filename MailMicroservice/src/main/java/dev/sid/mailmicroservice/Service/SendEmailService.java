package dev.sid.mailmicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    public SendEmailService (JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public JavaMailSender javaMailSender;

    @Value("$(hireshark.no-reply)")
    private String fromEmailId;

    public void sendEmail(String recipient, String body, String subject) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmailId);
        mailMessage.setTo(recipient);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

        javaMailSender.send(mailMessage);
        System.out.println("Email has been sent to "+ recipient);
    }
}
