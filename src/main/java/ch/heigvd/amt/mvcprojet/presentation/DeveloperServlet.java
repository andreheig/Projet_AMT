package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
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
    private ApplicationDAO applicationDAO;

    private static final Logger LOGGER = Logger.getLogger(AdminServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Application> list = applicationDAO.findUserApplication(user.getUserId());
        // Permet la pagination
        int page = 1;
        int recordPerPage = 10;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int nbApp = list.size();
        int nbPage = (int) Math.ceil(nbApp * 1.0 / recordPerPage);

        if(page*recordPerPage >= nbApp){
            list = list.subList(((page -1) *recordPerPage), nbApp);
        }
        else{
            list = list.subList(((page -1) *recordPerPage), page * recordPerPage);
        }
        request.setAttribute("nbPage", nbPage);
        request.setAttribute("page", page);

        response.setContentType("text/html;charset=UTF-8");
        LOGGER.log(Level.INFO, "list", session.getAttributeNames());
        request.setAttribute("applications", list);
        request.getRequestDispatcher("/WEB-INF/pages/dev.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            } else {
                throw new IllegalStateException("Invalid admin form");
            }
        }

    }

    }
