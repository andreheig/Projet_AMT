package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.business.ControlForm;
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
        boolean firstPassEmpty = false;

        // Test prénom
        if(firstName.isEmpty()){
            request.setAttribute("firstNameNull", "Prénom manquant");
        }
        else{
            request.removeAttribute("firstNameNull");
        }

        // Test nom
        if(lastName.isEmpty()){
            request.setAttribute("lastNameNull", "Nom manquant");
        }
        else{
            request.removeAttribute("lastNameNull");
        }

        // Test mail
        if(email.isEmpty()){
            request.setAttribute("emailNull", "Email manquant");
        }
        else{
            request.removeAttribute("emailNull");
        }
        if(!email.contains("@") || !email.contains(".")){
            request.setAttribute("emailInccorect", "Syntaxe eronné");
        }
        else{
            request.removeAttribute("emailInccorect");
        }

        // Test password
        if(password.isEmpty()){
            request.setAttribute("passwordNull", "Mot de passe manquant");
            firstPassEmpty = true;
        }
        else{
            request.removeAttribute("passwordNull");
        }

        // Test password2
        if(password2.isEmpty()){
            request.setAttribute("password2Null", "Mot de passe manquant");
        } else if (!firstPassEmpty) {
            request.removeAttribute("password2Null");
            if(password.compareTo(password2) != 0){
                request.setAttribute("password2NotMatch", "Mot de passe non concordant");
            }
            else{
                request.removeAttribute("password2NotMatch");
            }
        }

        Developper dev = new Developper(firstName, lastName, email, password);
        request.setAttribute("developper", dev);

        RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/form.jsp");
        requestDisp.forward(request, response);

    }

}
