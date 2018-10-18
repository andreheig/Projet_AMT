package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.UserManager;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private UserManager userManager;

    //@EJB
    //private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //TODO: A checker si c'est le premier affichage ou non

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("form",true);
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        boolean firstNameOK = false;
        boolean lastNameOK = false;
        boolean emailOK = false;
        boolean firstPassOK = false;
        boolean secondPassOK = false;

        // Test prénom
        if(firstName.isEmpty()){
            request.setAttribute("firstNameNull", "Prénom manquant");
            firstNameOK = false;
        }
        else{
            request.removeAttribute("firstNameNull");
            firstNameOK = true;
        }

        // Test nom
        if(lastName.isEmpty()){
            request.setAttribute("lastNameNull", "Nom manquant");
            lastNameOK = false;
        }
        else{
            request.removeAttribute("lastNameNull");
            lastNameOK = true;
        }

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
            firstPassOK = true;
        }

        // Test password2
        if(password2.isEmpty()){
            request.setAttribute("password2Null", "Mot de passe manquant");
        } else if (firstPassOK) {
            request.removeAttribute("password2Null");
            if(password.compareTo(password2) != 0){
                request.setAttribute("password2NotMatch", "Mot de passe non concordant");
            }
            else{
                request.removeAttribute("password2NotMatch");
                secondPassOK = true;
            }
        }

        if(firstNameOK && lastNameOK && emailOK && firstPassOK && secondPassOK){
            // TODO: Lancement vérif BDD + lancement page
            try {
                // Recerche si le mail existe déjà!
                User user = new User(lastName, firstName, email, password, "dev");
                /*user.setNom(lastName);
                user.setEmail(email);
                user.setPrenom(firstName);
                user.setType_compte("dev");
                user.setPassword(password);*/
                if(!userManager.userExist(user)){
                    // Le mail existe, l'utilisateur doit donc s'authentifier
                    response.sendRedirect("/Projet_AMT/login");
                    return;
                }
                else{
                    // Le mail n'existe pas, elle est rentrer dans la DB, on peut passer a la vue dev
                    response.sendRedirect("/Projet_AMT/test");
                    return;
                }
            }
            catch (Exception e){
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        //Developper dev = new Developper(firstName, lastName, email, password);
        //request.setAttribute("developper", dev);

        RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/register.jsp");
        requestDisp.forward(request, response);

    }

}
