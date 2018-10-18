package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.ApplicationsManager;
import ch.heigvd.amt.mvcprojet.Database.DevelopperManager;
import ch.heigvd.amt.mvcprojet.Database.UserManager;
import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.Developper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

            response.setContentType("text/html;charset=UTF-8");
            /* Partie test Users */
            request.setAttribute("users", userManager.findAllUser());
            //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

            request.setAttribute("applications", applicationManager.findUserApplication(4));
            //request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);

            request.setAttribute("developpers", developperManager.findDevelopper());
            request.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(request, response);
        }

}
