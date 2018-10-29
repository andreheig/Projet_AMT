package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServlet extends HttpServlet {

    @EJB
    private UserDAO userDAO;

    @EJB
    private DevelopperDAO developperDAO;

    @EJB
    private MailSender mailSender;

    private static final Logger LOGGER = Logger.getLogger(AdminServlet.class.getName());

    private static final int NEW_PASSWORD_LENGTH = 15;

    private final Random rand = new Random();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        LOGGER.log(Level.INFO, "list", session.getAttributeNames());
        request.setAttribute("developpers", developperDAO.findDevelopper());
        request.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if(paramName.contains("reset")) {
                doHandleResetPassword(paramName);
            } else if (paramName.contains("suspend")) {
                doHandleSuspendAccount(paramName);
            } else if (paramName.contains("reactivate")) {
                doHandleReactivateAccount(paramName);
            } else {
                throw new IllegalStateException("Invalid admin form");
            }
        }
        response.sendRedirect("admin");
    }

    private void doHandleResetPassword(String paramName) {
        Integer userId = Integer.parseInt(paramName.substring("reset-".length()));
        User dev = userDAO.loadUser(userId);
        String newPassword = generateAndSendNewPassword(dev.getEmail());
        developperDAO.resetPassword(userId, newPassword);
    }

    private String generateAndSendNewPassword(String email) {
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

    private void doHandleSuspendAccount(String paramName) {
        developperDAO.suspendDeveloper(
                Integer.parseInt(paramName.substring("suspend-".length())));
    }

    private void doHandleReactivateAccount(String paramName) {
        developperDAO.reactivateDeveloper(
                Integer.parseInt(paramName.substring("reactivate-".length())));
    }
}
