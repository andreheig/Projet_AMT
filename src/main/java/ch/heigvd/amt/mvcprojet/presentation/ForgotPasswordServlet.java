package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.DevelopperDAOLocal;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAOLocal;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForgotPasswordServlet extends HttpServlet {

    @EJB
    private UserDAOLocal userDAO;

    @EJB
    private DevelopperDAOLocal devDAO;

    @EJB
    MailSender mailSender;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/forgotPassword.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("forgotPasswordEmail");
        User dev = userDAO.loadUser(email);
        if(dev != null) {
            String newPassword = Utils.generateAndSendNewPassword(mailSender, dev.getEmail());
            devDAO.resetPassword(dev.getUserId(), newPassword);
        }
        response.sendRedirect("home");
    }
}
