package ch.heigvd.amt.mvcprojet.presentation;

        import java.io.IOException;
        import java.io.PrintWriter;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            request.setAttribute("pageTitle", "Welcome");
            request.setAttribute("nbOfAccounts",accountDAO.count());
            request.setAttribute("nbOfApplications", applicationDAO.count());
            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
