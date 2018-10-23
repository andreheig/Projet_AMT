package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.ApplicationsManager;
import ch.heigvd.amt.mvcprojet.Database.DevelopperManager;
import ch.heigvd.amt.mvcprojet.Database.UserManager;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServlet extends HttpServlet {

    @EJB
    private DevelopperManager developperManager;

    private static final Logger LOGGER = Logger.getLogger(AdminServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        LOGGER.log(Level.INFO, "list", session.getAttributeNames());
        request.setAttribute("developpers", developperManager.findDevelopper());
        request.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);
    }

}
