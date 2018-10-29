package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePasswordServlet extends HttpServlet {

    @EJB
    private UserDAO userDAO;

    @EJB
    private DevelopperDAO developperDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("changePass",true);
        request.getRequestDispatcher("/WEB-INF/pages/changePass.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("password");
        String password2 = request.getParameter("passwordCheck");

        boolean firstPassOK = false;
        boolean secondPassOK = false;

        // Test password
        if(password.isEmpty()){
            request.setAttribute("passwordNull", "Mot de passe manquant");
        }
        else{
            request.removeAttribute("passwordNull");
            firstPassOK = true;
        }

        // Test password2
        if(password2.isEmpty()){
            request.setAttribute("password2Null", "Mot de passe manquant");
        } else if (firstPassOK) {
            request.removeAttribute("password2Null");
            if(password.compareTo(password2) != 0){
                request.setAttribute("password2NotMatch", "Mot de passe non concordant");
            }
            else{
                request.removeAttribute("password2NotMatch");
                secondPassOK = true;
                user.setPassword(password);
                userDAO.updatePassword(user);
            }
        }
        response.sendRedirect("dev");
    }
}
