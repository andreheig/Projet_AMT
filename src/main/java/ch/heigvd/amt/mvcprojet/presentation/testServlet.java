package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.ApplicationsManager;
import ch.heigvd.amt.mvcprojet.Database.DevelopperManager;
import ch.heigvd.amt.mvcprojet.Database.UserManager;
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
        private UserManager userManager;

        @EJB
        private ApplicationsManager applicationManager;

        @EJB
        private DevelopperManager developperManager;

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
            if(user == null){
                response.sendRedirect("/Projet_AMT/home");
                return;
            }
            else {

                response.setContentType("text/html;charset=UTF-8");

                Logger.getLogger(testServlet.class.getName()).log(Level.INFO, "list", session.getAttributeNames());
                /* Partie test Users */
                if (user.getType_compte().equalsIgnoreCase("admin")) {
                    request.setAttribute("developpers", developperManager.findDevelopper());
                } else if (user.getType_compte().equalsIgnoreCase("dev")) {
                    request.setAttribute("applications", applicationManager.findUserApplication(user.getUser_id()));
                }
                request.setAttribute("users", userManager.findAllUser());
                //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

                //request.setAttribute("applications", applicationManager.findUserApplication(4));
                //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

                //request.setAttribute("developpers", developperManager.findDevelopper());
                request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);
            }
        }

}
