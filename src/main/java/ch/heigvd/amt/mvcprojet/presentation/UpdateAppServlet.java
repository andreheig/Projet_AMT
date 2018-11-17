package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.*;
import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class UpdateAppServlet extends HttpServlet {

    @EJB
    private ApplicationDAOLocal appliDAO;

    @EJB
    private UserDAOLocal userDAO;

    @EJB
    private DevelopperDAOLocal devDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appId = Integer.parseInt(request.getParameter("appId"));
        Application app = appliDAO.loadAppli(appId);
        request.setAttribute("app", app);
        request.getRequestDispatcher("/WEB-INF/pages/updateApp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.contains("update-app")) {
                doHandleUpdateApp(request, paramName);
                break;
            } else if(paramName.contains("add-user")) {
                doHandleAddUserToApp(request, paramName);
                break;
            }
        }
        response.sendRedirect("../dev");
    }

    private void doHandleUpdateApp(HttpServletRequest request, String paramName) {
        int appId = Integer.parseInt(paramName.substring("update-app-".length()));
        String name = request.getParameter("appName");
        String description = request.getParameter("appDescription");
        appliDAO.updateAppli(new Application(appId, name, description));
    }

    private void doHandleAddUserToApp(HttpServletRequest request, String paramName) {
        int appId = Integer.parseInt(paramName.substring("add-user-".length()));
        String email = request.getParameter(paramName);
        User user = userDAO.loadUser(email);
        if(user != null && "dev".equals(user.getAccountType())) {
            devDAO.addDevToApp(user.getUserId(), appId);
        }
    }
}
