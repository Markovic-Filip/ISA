package isa.isa.QRCode.email.impl;

import isa.isa.QRCode.email.EmailService;
import isa.isa.user.domain.Donator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("centarzakrv@gmail.com");
        message.setTo("napicaksrece@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("centarzakrv@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file
                = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("QR.png", file);

        emailSender.send(message);
    }

    @Override
    public void sendVerificationEmail(Donator donator) throws MessagingException, UnsupportedEncodingException {
        String toAddress = donator.getEmail();
        String subject = "Molim Vas verifikujete vasu registraciju";
        String content = "Postovani [[name]],<br>"
        + "Molim Vas kliknite na link za verifikaciju registracije ispod:<br>"
        + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
        + "Hvala,<br>"
        + "Zavod za transfuziju.";

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("centarzakrv@gmail.com", "Zavod za transfuziju");
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", donator.getName());
        String verifyURL = "http://localhost:8090/auth" + "/verify?code=" + donator.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        emailSender.send(message);

    }

}
