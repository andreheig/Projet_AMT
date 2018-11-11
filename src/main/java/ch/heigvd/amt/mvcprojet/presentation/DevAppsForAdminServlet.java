package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
import ch.heigvd.amt.mvcprojet.model.Application;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DevAppsForAdminServlet extends HttpServlet {

    @EJB
    private ApplicationDAO appDAO;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int devId = Integer.parseInt(request.getParameter("devId"));
        List<Application> apps = appDAO.findUserApplication(devId);

        request.setAttribute("devId", devId);
        request.setAttribute("apps", apps);
        request.getRequestDispatcher("/WEB-INF/pages/devAppsForAdmin.jsp").forward(request, response);
    }
}
