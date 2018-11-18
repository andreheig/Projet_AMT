package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.IDevelopperDAOLocal;
import ch.heigvd.amt.mvcprojet.database.IUserDAOLocal;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private IUserDAOLocal userDAO;

    @EJB
    private IDevelopperDAOLocal devDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("register",true);
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        boolean firstNameOK = false;
        boolean lastNameOK = false;
        boolean emailOK = false;
        boolean firstPassOK = false;
        boolean secondPassOK = false;

        // Test prénom
        if(firstname.isEmpty()){
            request.setAttribute("firstNameNull", "Prénom manquant");
            firstNameOK = false;
        }
        else{
            request.removeAttribute("firstNameNull");
            firstNameOK = true;
        }

        // Test nom
        if(lastname.isEmpty()){
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
            try {
                // Recerche si le mail existe déjà!
                User user = new User(lastname, firstname, email, password, "dev");
                if(userDAO.userExist(user)){
                    request.setAttribute("EmailAlreadyExist", "Cet email existe déja !");
                    // Le mail existe, l'utilisateur doit donc s'authentifier
                    this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
                   // response.sendRedirect("/Projet_AMT/login");
                    return;
                }
                else{
                    // Le mail n'existe pas, elle est rentrer dans la DB,
                    userDAO.insertUser(user);
                    // On peut passer a la vue dev
                    try {

                        // Recherche si le mail existe déjà dans la DB!
                        user = userDAO.loadUser(email);

                        if (userDAO.userExist(user) && userDAO.loginMatch(user, password)) {

                            // Le mail existe, l'utilisateur est autorisé
                            HttpSession session = request.getSession();
                            session.setAttribute("user", userDAO.setUserSession(user));
                            final String accountType = user.getAccountType();

                            if ("admin".equals(accountType)) {
                                response.sendRedirect("/Projet_AMT/admin");
                                return;
                            } else if ("dev".equals(accountType)) {
                                    response.sendRedirect("/Projet_AMT/dev");
                                return;
                            }
                        }
                    } catch (Exception e) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
            catch (Exception e){
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        User dev = new User(firstname, lastname, email, password, "dev");
        request.setAttribute("developper", dev);

        RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/register.jsp");
        requestDisp.forward(request, response);

    }

}
