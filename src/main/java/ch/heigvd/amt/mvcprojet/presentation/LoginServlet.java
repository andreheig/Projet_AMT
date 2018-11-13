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

            boolean emailOK = false;
            boolean passOK = false;
            boolean isSuspended = false;
            String suspendedMessage = "";

            // Test presence d'un mot dans le champ mail
            if (email.isEmpty()) {
                request.setAttribute("emailNull", "Email manquant");
            } else {
                request.removeAttribute("emailNull");
            }

            // test si il s'agit d'un mail
            if (!email.contains("@") || !email.contains(".")) {
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


                // Recherche si le mail existe déjà dans la DB!
                User user = userDAO.loadUser(email);

                if (userDAO.userExist(user) && userDAO.loginMatch(user, password)) {

                    // Le mail existe, l'utilisateur est autorisé
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userDAO.setUserSession(user));
                    final String accountType = user.getAccountType();
                    isSuspended = true;//devDAO.isDeveloperSuspended(user.getUserId());


                    if ("admin".equals(accountType)) {
                        response.sendRedirect("/Projet_AMT/admin");
                        return;
                    } else if("dev".equals(accountType)) {


                        if (isSuspended) {

                            suspendedMessage = "Vous avez été suspendu, veuillez contacter votre Admin !";
                            request.setAttribute("error", suspendedMessage);
                            response.sendRedirect("/Projet_AMT/home");
                            return;

                        } else if (devDAO.hasToResetPassword(user)){

                            response.sendRedirect("/Projet_AMT/changePass");
                            return;

                        }


                        response.sendRedirect("/Projet_AMT/dev");
                        return;

                    }
                }

            }

            User userlog = new User("", "", email, password, "");
            request.setAttribute("user", userlog);

            RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp");
            requestDisp.forward(request, response);
            return;


        }

    }
