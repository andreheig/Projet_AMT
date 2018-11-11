package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
import ch.heigvd.amt.mvcprojet.model.Application;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAppServlet extends HttpServlet {

    @EJB
    private ApplicationDAO appliDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appId = Integer.parseInt(request.getParameter("appId"));
        Application app = appliDAO.loadAppli(appId);
        request.setAttribute("appName", app.getName());
        request.setAttribute("appDescription", app.getDescription());
        request.getRequestDispatcher("/WEB-INF/pages/updateApp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("appName");
        String description = request.getParameter("appDescription");



        request.getRequestDispatcher("/WEB-INF/pages/dev.jsp").forward(request, response);
    }

}
