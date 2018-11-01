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
        int recordPerPage = 5;
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
        /*
        if (page == 1){
            list = list.subList((page-1), (page*recordPerPage));
        }
        else if(page*recordPerPage >= nbApp){
            list = list.subList(((page -1) *recordPerPage), nbApp);
        }
        else{
            list = list.subList((page*recordPerPage), (page*recordPerPage + recordPerPage));
        }
        */
        request.setAttribute("nbPage", nbPage);
        request.setAttribute("page", page);

        response.setContentType("text/html;charset=UTF-8");
        LOGGER.log(Level.INFO, "list", session.getAttributeNames());
        request.setAttribute("applications", list);
        request.getRequestDispatcher("/WEB-INF/pages/dev.jsp").forward(request, response);
    }
}
