package ch.heigvd.amt.mvcprojet.presentation;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Stateless
public class MailSender {

    @Resource(name = "java/mail/AMTProject")
    Session mailSession;

    public void sendResetPasswordEmail(String email, String password) throws UnsupportedEncodingException, MessagingException {
        Message message = new MimeMessage(mailSession);

        message.setSubject("Password reset");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setText("Hi! \n\n Your password has been reset. Please use this temporary password " +
                "to log in and change it:\n" + password + "\n\nBest regards,\nthe Gameify Ultimate Team");
        
        Transport.send(message);
    }
}
