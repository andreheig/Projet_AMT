package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.UserManager;
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

public class LoginServlet extends javax.servlet.http.HttpServlet{


    @EJB
    private UserManager userManager;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("login",true);
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean emailOK = false;
        boolean passOK = false;

        // Test mail
        if(email.isEmpty()){
            request.setAttribute("emailNull", "Email manquant");
            emailOK = false;
        }
        else{
            request.removeAttribute("emailNull");
        }
        if(!email.contains("@") || !email.contains(".")){
            request.setAttribute("emailInccorect", "Syntaxe eronné");
            emailOK = false;
        }
        else{
            request.removeAttribute("emailInccorect");
            emailOK = true;
        }

        // Test password
        if(password.isEmpty()){
            request.setAttribute("passwordNull", "Mot de passe manquant");
        }
        else{
            request.removeAttribute("passwordNull");
            passOK = true;
        }

        if(emailOK && passOK){
            // TODO: Lancement vérif BDD + lancement page
            try {
                // Recerche si le mail existe déjà!
                // TODO : Fait-on une classe login, ou la classe User rempli comme ça suffit?
                User user = userManager.loadUser(email);
                if(userManager.userExist(user) && userManager.loginMatch(user, password)){
                    // Le mail existe, l'utilisateur est autorisé
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userManager.setUserSession(user));

                    final String accountType = user.getType_compte();
                    if("admin".equals(accountType)) {
                        response.sendRedirect("/Projet_AMT/admin");
                    } else if("dev".equals(accountType)) {
                        response.sendRedirect("/Projet_AMT/dev");
                    } else {
                        throw new IllegalStateException("Account type is not correct: " + accountType);
                    }
                    return;
                }
                else{
                    // Le mail n'existe pas, l'utilisateur doit donc s'enregistrer
                    response.sendRedirect("/Projet_AMT/register");
                    return;
                }
            }
            catch (Exception e){
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        User user = new User("", "", email, password, "");
        request.setAttribute("user", user);

        RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp");
        requestDisp.forward(request, response);

    }

}
