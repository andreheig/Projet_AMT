package ch.heigvd.amt.mvcprojet.web;

import ch.heigvd.amt.mvcprojet.database.IApplicationDAOLocal;
import ch.heigvd.amt.mvcprojet.database.IUserDAOLocal;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends javax.servlet.http.HttpServlet {

    @EJB
    IUserDAOLocal userDAOLocal;

    @EJB
    IApplicationDAOLocal applicationDAOLocal;

    final static int INSERTEXIST = 0;
    final static int DELETENOTWORK = 1;
    final static int DELETEWORK = 2;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int test = INSERTEXIST; // A remplacer par INSERTEXIST, DELETENOTWORK ou DELETEWORK

        int numberOfUsersBefore = -1;
        int numberOfUsersAfter = -1;

        int numberOfAppsBefore = -1;
        int numberOfAppsAfter = -1;

        int numberOfAppsUser = -1;


        try {
            User user = null;
            switch (test) {
                case 0:
            /*
            Test d'insertion d'un utilisateur déjà présent
             */
                    numberOfUsersBefore = userDAOLocal.countUsers();
                    numberOfAppsBefore = applicationDAOLocal.countApplications();
                    response.getWriter().println("Insertion d'un utilisateur.\n");
                    User notWork = new User("Bob", "Eponge", "bob.eponge@heig-vd.ch", "pass", "dev");
                    userDAOLocal.insertUser(notWork);
                    response.getWriter().println("Fin insertion d'un utilisateur.\n");
                    break;
                case 1:
            /*
            Test de suppression échoué d'un utilisateur
             */
                user = userDAOLocal.loadUser(6);

                    numberOfUsersBefore = userDAOLocal.countUsers();
                    numberOfAppsBefore = applicationDAOLocal.countApplications();
                    response.getWriter().println("Suppression d'un utilisateur échoué.\n");
                    userDAOLocal.deleteUser(user, true);
                    response.getWriter().println("Fin suppression d'un utilisateur échoué.\n");
                    break;
                case 2:
            /*
            Test de suppression réussi d'un utilisateur
             */
                    user = userDAOLocal.loadUser(4);
                    numberOfUsersBefore = userDAOLocal.countUsers();
                    numberOfAppsBefore = applicationDAOLocal.countApplications();
                    numberOfAppsUser = applicationDAOLocal.findUserApplication(4).size();
                    response.getWriter().println("Suppression d'un utilisateur.\n");
                    userDAOLocal.deleteUser(user, false);
                    response.getWriter().println("Fin suppression d'un utilisateur.\n");
                    break;
            }


        } catch (Exception e) {

            response.getWriter().println(e.getMessage());
            response.getWriter().println("Problème pendant les test sur les EJB.\n");

        } finally {

            numberOfUsersAfter = userDAOLocal.countUsers();
            numberOfAppsAfter = applicationDAOLocal.countApplications();
            switch(test) {
                case 0:
            /*
            Insertion utilisateur échoué
             */
                    response.getWriter().println(String.format("Nombre d'utilisateur avant insertion d'utilisateur raté: %d\n", numberOfUsersBefore));
                    response.getWriter().println(String.format("Nombre d'utilisateur après insertion d'utilisateur raté: %d\n", numberOfUsersAfter));

                    response.getWriter().println(String.format("Nombre d'applications avant insertion d'utilisateur raté: %d\n", numberOfAppsBefore));
                    response.getWriter().println(String.format("Nombre d'applications avant insertion d'utilisateur raté: %d\n", numberOfAppsAfter));
                    break;
                case 1:
            /*
            Suppression utilisateur raté
             */
                    response.getWriter().println(String.format("Nombre d'utilisateur avant suppression d'utilisateur raté: %d\n", numberOfUsersBefore));
                    response.getWriter().println(String.format("Nombre d'utilisateur après suppression d'utilisateur raté: %d\n", numberOfUsersAfter));

                    response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur raté: %d\n", numberOfAppsBefore));
                    response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur raté: %d\n", numberOfAppsAfter));
                    break;
                case 2:
            /*
            Suppression utilisateur OK
             */
                    response.getWriter().println(String.format("Nombre d'utilisateur avant suppression d'utilisateur OK: %d\n", numberOfUsersBefore));
                    response.getWriter().println(String.format("Nombre d'utilisateur après suppression d'utilisateur OK: %d\n", numberOfUsersAfter));

                    response.getWriter().println(String.format("Nombre d'applications de l'utilisateur supprimé: %d\n", numberOfAppsUser));
                    response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur OK: %d\n", numberOfAppsBefore));
                    response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur OK: %d\n", numberOfAppsAfter));
                    break;
            }
        }

    }

}