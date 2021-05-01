package enet.project.appointment;
import javax.mail.Session;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {






    private JavaMailSender javaMailSender;

    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) {
    	System.out.println("sending email") ; 

        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText("gggg");

        mailMessage.setFrom("cesarapo525@gmail.com");

        javaMailSender.send(mailMessage);
        System.out.println("sent email...") ; 
      
    }
}