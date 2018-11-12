package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.model.User;
import ch.heigvd.amt.mvcprojet.model.Developper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");

        // Pagination
        int pageToLoad = request.getParameter("page") != null ?
                Integer.parseInt(request.getParameter("page")) :
                1;
        int nbDev = developperDAO.getNumberOfDevelopper();
        int nbPage = (int) Math.ceil((nbDev * 1.0) / Utils.NB_MAX_ELEMENTS_ON_PAGE);

        request.setAttribute("nbPages", nbPage);
        request.setAttribute("page", pageToLoad);
        List<Developper> list = developperDAO.findDeveloppersForPage(pageToLoad, Utils.NB_MAX_ELEMENTS_ON_PAGE);

        LOGGER.log(Level.INFO, "list", session.getAttributeNames());
        request.setAttribute("developpers", list);
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
        String newPassword = Utils.generateAndSendNewPassword(mailSender, dev.getEmail());
        developperDAO.resetPassword(userId, newPassword);
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
