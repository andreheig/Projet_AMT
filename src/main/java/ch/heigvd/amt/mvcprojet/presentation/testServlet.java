package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAO;
import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testServlet extends HttpServlet {

        @EJB
        private UserDAO userDAO;

        @EJB
        private ApplicationDAO applicationDAO;

        @EJB
        private DevelopperDAO developperDAO;

        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            /*if(user == null){
                response.sendRedirect("/Projet_AMT/home");
                return;
            }
            else {*/

                response.setContentType("text/html;charset=UTF-8");

                Logger.getLogger(testServlet.class.getName()).log(Level.INFO, "list", session.getAttributeNames());
                /* Partie test Users */
                if (user.getAccountType().equalsIgnoreCase("admin")) {
                    request.setAttribute("developpers", developperDAO.findDeveloppersForPage(1, Utils.NB_MAX_ELEMENTS_ON_PAGE));
                } else if (user.getAccountType().equalsIgnoreCase("dev")) {
                    request.setAttribute("applications", applicationDAO.findUserApplication(user.getUserId()));
                }
                request.setAttribute("users", userDAO.findAllUser());
                //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

                //request.setAttribute("applications", applicationManager.findUserApplication(4));
                //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

                //request.setAttribute("developpers", developperDAO.findDeveloppersForPage());
                request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);
           // }
        }

}
