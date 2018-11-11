package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
import ch.heigvd.amt.mvcprojet.model.Application;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class UpdateAppServlet extends HttpServlet {

    @EJB
    private ApplicationDAO appliDAO;

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
        int id = -1;
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.contains("update-app")) {
                id = Integer.parseInt(paramName.substring("update-app-".length()));
                break;
            }
        }
        String name = request.getParameter("appName");
        String description = request.getParameter("appDescription");
        appliDAO.updateAppli(new Application(id, name, description));
        response.sendRedirect("../dev");
    }

}
