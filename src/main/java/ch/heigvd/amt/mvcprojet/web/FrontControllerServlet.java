package ch.heigvd.amt.mvcprojet.web;

import ch.heigvd.amt.mvcprojet.database.ApplicationDAOLocal;
import ch.heigvd.amt.mvcprojet.database.UserDAOLocal;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends javax.servlet.http.HttpServlet {

    @EJB
    UserDAOLocal userDAOLocal;

    @EJB
    ApplicationDAOLocal applicationDAOLocal;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int numberOfUserBeforeFakeUserInsert = -1;
        int numberOfUserAfterFakeUserInsert = -1;

        int numberOfAppsBeforeFakeUserInsert = -1;
        int numberOfAppsAfterFakeUserInsert = -1;

        int numberOfUserBeforeFakeUserDelete = -1;
        int numberOfUserAfterFakeUserDelete = -1;

        int numberOfAppsBeforeFakeUserDelete = -1;
        int numberOfAppsAfterFakeUserDelete = -1;

        int numberOfUserBeforeUserDelete = -1;
        int numberOfUserAfterUserDelete = -1;

        int numberOfAppsBeforeUserDelete = -1;
        int numberOfAppsAfterUserDelete = -1;
        int numberOfAppsOfUserDelete = -1;


        try {
            User user = null;
            /*
            Test d'insertion d'un utilisateur déjà présent
             */
            user = userDAOLocal.loadUser(146);
            numberOfUserBeforeFakeUserInsert = userDAOLocal.countUsers();
            numberOfAppsBeforeFakeUserInsert = applicationDAOLocal.countApplications();
            response.getWriter().println("Insertion d'un utilisateur.\n");
            User notWork = new User("Bob", "Eponge", "bob.eponge@heig-vd.ch", "pass", "dev");
            // Ligne du dessous à commenter pour faire fonctionner un des autre test
            userDAOLocal.insertUser(notWork);
            response.getWriter().println("Fin insertion d'un utilisateur.\n");

            /*
            Test de suppression échoué d'un utilisateur
             */
            user = userDAOLocal.loadUser(6);

            numberOfUserBeforeFakeUserDelete = userDAOLocal.countUsers();
            numberOfAppsBeforeFakeUserDelete = applicationDAOLocal.countApplications();

            response.getWriter().println("Suppression d'un utilisateur échoué.\n");
            // Ligne du dessous à commenter pour faire fonctionner un des autre test
            userDAOLocal.deleteUser(user, true);
            response.getWriter().println("Fin suppression d'un utilisateur échoué.\n");

            /*
            Test de suppression réussi d'un utilisateur
             */
            user = userDAOLocal.loadUser(4);

            numberOfUserBeforeUserDelete = userDAOLocal.countUsers();
            numberOfAppsBeforeUserDelete = applicationDAOLocal.countApplications();
            numberOfAppsOfUserDelete = applicationDAOLocal.findUserApplication(4).size();

            response.getWriter().println("Suppression d'un utilisateur.\n");
            userDAOLocal.deleteUser(user, false);
            response.getWriter().println("Fin suppression d'un utilisateur.\n");


        } catch (Exception e) {

            response.getWriter().println(e.getMessage());
            response.getWriter().println("Problème pendant les test sur les EJB.\n");

        } finally {

            numberOfUserAfterFakeUserInsert = userDAOLocal.countUsers();
            numberOfAppsAfterFakeUserInsert = applicationDAOLocal.countApplications();

            numberOfUserAfterFakeUserDelete = userDAOLocal.countUsers();
            numberOfAppsAfterFakeUserDelete = applicationDAOLocal.countApplications();

            numberOfUserAfterUserDelete = userDAOLocal.countUsers();
            numberOfAppsAfterUserDelete = applicationDAOLocal.countApplications();
            /*
            Insertion utilisateur échoué
             */
            response.getWriter().println(String.format("Nombre d'utilisateur avant insertion d'utilisateur raté: %d\n", numberOfUserBeforeFakeUserInsert));
            response.getWriter().println(String.format("Nombre d'utilisateur après insertion d'utilisateur raté: %d\n", numberOfUserAfterFakeUserInsert));

            response.getWriter().println(String.format("Nombre d'applications avant insertion d'utilisateur raté: %d\n", numberOfAppsBeforeFakeUserInsert));
            response.getWriter().println(String.format("Nombre d'applications avant insertion d'utilisateur raté: %d\n", numberOfAppsAfterFakeUserInsert));

            /*
            Suppression utilisateur raté
             */
            response.getWriter().println(String.format("Nombre d'utilisateur avant suppression d'utilisateur raté: %d\n", numberOfUserBeforeFakeUserDelete));
            response.getWriter().println(String.format("Nombre d'utilisateur après suppression d'utilisateur raté: %d\n", numberOfUserAfterFakeUserDelete));

            response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur raté: %d\n", numberOfAppsBeforeFakeUserDelete));
            response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur raté: %d\n", numberOfAppsAfterFakeUserDelete));

            /*
            Suppression utilisateur OK
             */
            response.getWriter().println(String.format("Nombre d'utilisateur avant suppression d'utilisateur OK: %d\n", numberOfUserBeforeUserDelete));
            response.getWriter().println(String.format("Nombre d'utilisateur après suppression d'utilisateur OK: %d\n", numberOfUserAfterUserDelete));

            response.getWriter().println(String.format("Nombre d'applications de l'utilisateur supprimé: %d\n", numberOfAppsOfUserDelete));
            response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur OK: %d\n", numberOfAppsBeforeUserDelete));
            response.getWriter().println(String.format("Nombre d'applications avant suppression d'utilisateur OK: %d\n", numberOfAppsAfterUserDelete));

        }

    }

}