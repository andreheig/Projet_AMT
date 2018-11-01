package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.DevelopperDAO;
import ch.heigvd.amt.mvcprojet.database.UserDAO;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServlet extends javax.servlet.http.HttpServlet {


    @EJB
    private UserDAO userDAO;

    @EJB
    private DevelopperDAO devDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("login", true);
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String message = "";

        boolean emailOK = false;
        boolean passOK  = false;

        // Test mail
        if (email.isEmpty()) {
            emailOK = false;
            request.setAttribute("emailNull", "Email manquant");
        } else {
            request.removeAttribute("emailNull");
        }


        if (!email.contains("@") || !email.contains(".")) {
            emailOK = false;
            request.setAttribute("emailInccorect", "Syntaxe eronné");
        } else {
            emailOK = true;
            request.removeAttribute("emailInccorect");
        }


        // Test password
        if (password.isEmpty()) {
            request.setAttribute("passwordNull", "Mot de passe manquant");
        } else {
            passOK = true;
            request.removeAttribute("passwordNull");
        }


        if (emailOK && passOK) {
            // TODO: Lancement vérif BDD + lancement page
            // try {
            // Recherche si le mail existe déjà!
            // TODO : Fait-on une classe login, ou la classe User rempli comme ça suffit?
            User user = userDAO.loadUser(email);

            if (userDAO.userExist(user) && userDAO.loginMatch(user, password)) {

                // Le mail existe, l'utilisateur est autorisé
                HttpSession session = request.getSession();
                session.setAttribute("user", userDAO.setUserSession(user));
                final String accountType = user.getAccountType();
                boolean isSuspended = devDAO.isDeveloperSuspended(user.getUserId());

                if ("admin".equals(accountType)) {
                    response.sendRedirect("/Projet_AMT/admin");
                    return;
                } else if ("dev".equals(accountType)) {

                    if (isSuspended) {
                        // message = "Vous avez été suspendu, veuillez contacter votre Admin !";
                        // TODO : tenté d'implémenter un message d'erreur
                        request.setAttribute("error","Vous avez été suspendu, veuillez contacter votre Admin !");
                        response.sendRedirect("/Projet_AMT/login");


                    } else if (devDAO.hasToResetPassword(user)) {
                        response.sendRedirect("/Projet_AMT/changePass");
                    } else {
                        response.sendRedirect("/Projet_AMT/dev");

                    }
                    // } else {
                    //     throw new IllegalStateException("Account type is not correct: " + accountType);
                    //  }


                    return;

                } else {

                    message = "Connexion échouée, mauvaise combinaison identifiant/mot de passe !";
                    request.setAttribute("error", "Connexion échouée, mauvaise combinaison identifiant/mot de passe !");
                    // getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);


                    // Le mail n'existe pas, l'utilisateur doit donc s'enregistrer
                    // response.sendRedirect("/Projet_AMT/register");
                    return;
                }
                // } catch (Exception e) {
                //     Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
                // }
            }




        }

        // request.setAttribute("error", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

    }

}
