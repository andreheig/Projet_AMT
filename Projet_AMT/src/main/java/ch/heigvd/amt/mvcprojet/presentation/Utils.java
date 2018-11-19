package ch.heigvd.amt.mvcprojet.presentation;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Utils {

    public static final int NB_MAX_ELEMENTS_ON_PAGE = 10;

    private static final int NEW_PASSWORD_LENGTH = 15;

    private final static Random rand = new Random();

    public static String generateAndSendNewPassword(MailSender mailSender, String email) {
        StringBuilder passwordBuilder = new StringBuilder();
        for(int i = 0; i < NEW_PASSWORD_LENGTH; i++) {
            // ascii rang 33 - 126 (0 - 93)
            passwordBuilder.append((char) (rand.nextInt(94) + 33));
        }
        String newPassword = passwordBuilder.toString();
        try {
            mailSender.sendResetPasswordEmail(email, newPassword);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return newPassword;
    }

}
