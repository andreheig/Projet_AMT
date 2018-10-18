package ch.heigvd.amt.mvcprojet.presentation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("login",true);
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
