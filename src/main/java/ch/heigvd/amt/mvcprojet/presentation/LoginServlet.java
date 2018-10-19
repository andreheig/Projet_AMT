package ch.heigvd.amt.mvcprojet.presentation;




import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServelet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);

        if(session != null)
            session.invalidate();

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter())
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String message;
            boolean success = false;


            Account a = accountDAO.verifyLogin(email, password);

            if (a != null)
            {
                message = "sucessfully connected";
                success = true;
            } else
            {
                message = "Wrong email or password. Please try again!";
            }

            request.setAttribute("success", message);
            request.setAttribute("pageTitle", "Account created");

            if (success)
            {
                request.getSession().setAttribute("connected", email);
                request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
            } else
            {
                request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
