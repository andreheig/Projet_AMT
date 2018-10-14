package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.Database.DBInterraction;
import ch.heigvd.amt.mvcprojet.model.Developper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

public class FormServlet extends javax.servlet.http.HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //TODO: A checker si c'est le premier affichage ou non

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("form",true);
        request.getRequestDispatcher("/WEB-INF/pages/form.jsp").forward(request, response);
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
            DBInterraction db = new DBInterraction();
            try {
                // Recerche si le mail existe déjà!
                if(db.emailExist(email) != 0){
                    // Le mail existe, l'utilisateur doit donc s'authentifier
                }
                else{
                    // Le mail n'existe pas, on peut entrer la personne dans la DB
                }
            }
            catch (Exception e){

            }
        }

        Developper dev = new Developper(firstName, lastName, email, password);
        request.setAttribute("developper", dev);

        RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/form.jsp");
        requestDisp.forward(request, response);

    }

}
