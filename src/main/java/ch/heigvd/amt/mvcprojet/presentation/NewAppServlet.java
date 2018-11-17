package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class NewAppServlet extends HttpServlet {

    @EJB
    private ApplicationDAO appliDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/newApp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("appName");
        String description = request.getParameter("appDescription");

        if(name.isEmpty() && description.isEmpty()){
            request.setAttribute("AppError", "cette application n'a pas été correctement definie !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/pages/newApp.jsp").forward(request, response);
            //response.sendRedirect("/Projet_AMT/dev/newApp");
            return;
        }
        else {
            UUID uuid = UUID.randomUUID();
            String keyUUID = uuid.toString();

            uuid = UUID.randomUUID();
            String secretUUID = uuid.toString();

            appliDAO.createAppli(user.getUserId(), new Application(name, description, keyUUID, secretUUID));
            request.setAttribute("request OK", true);

            response.sendRedirect("../dev");
        }
    }
}
