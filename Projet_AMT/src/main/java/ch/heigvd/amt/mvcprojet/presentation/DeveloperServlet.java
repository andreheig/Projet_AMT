package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.IApplicationDAOLocal;
import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.User;

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

public class DeveloperServlet extends HttpServlet {

    @EJB
    private IApplicationDAOLocal applicationDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int devId = ((User) session.getAttribute("user")).getUserId();
        response.setContentType("text/html;charset=UTF-8");
        PaginationHelper.addPaginationAttributesToRequest(request, applicationDAO, devId, "apps");
        request.getRequestDispatcher("/WEB-INF/pages/dev.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if(paramName.contains("update-app")) {
                int appId = Integer.parseInt(paramName.substring("update-app-".length()));
                response.sendRedirect("/Projet_AMT/dev/updateApp?appId=" + appId);
                return;
            } else if (paramName.contains("new-application")) {
                response.sendRedirect("/Projet_AMT/dev/newApp");
                return;
            } else if(paramName.contains("delete-app")) {
                int appId = Integer.parseInt(paramName.substring("delete-app-".length()));
                applicationDAO.deleteAppli(appId);
                response.sendRedirect("/Projet_AMT/dev");
                return;
            }
        }
        throw new IllegalStateException("Invalid admin form");
    }

    }
