package isa.isa.QRCode.email;

import isa.isa.user.domain.Donator;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {

    public void sendSimpleMessage(
            String to, String subject, String text);

    public void sendMessageWithAttachment(
            String to, String subject, String text, String pathToAttachment) throws MessagingException;

    public void sendVerificationEmail(Donator donator)throws MessagingException, UnsupportedEncodingException;

}
