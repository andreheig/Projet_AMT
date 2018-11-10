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

                try {

                    // Recherche si le mail existe déjà dans la DB!
                    User user = userDAO.loadUser(email);

                    if (userDAO.userExist(user) && userDAO.loginMatch(user, password)) {

                        // Le mail existe, l'utilisateur est autorisé
                        HttpSession session = request.getSession();
                        session.setAttribute("user", userDAO.setUserSession(user));
                        final String accountType = user.getAccountType();

                        if ("admin".equals(accountType)) {
                            response.sendRedirect("/Projet_AMT/admin");
                            return;
                        } else if ("dev".equals(accountType)) {

                            boolean isSuspended = devDAO.isDeveloperSuspended(user.getUserId());
                            if (isSuspended) {
                                request.setAttribute("error", "Vous avez été suspendu, veuillez contacter votre Admin !");
                                response.sendRedirect("/Projet_AMT/login");



                            } else if (devDAO.hasToResetPassword(user)) {
                                response.sendRedirect("/Projet_AMT/changePass");

                            } else {
                                response.sendRedirect("/Projet_AMT/dev");

                            }

                           return;
                        } else {
                            throw new IllegalStateException("Account type is not correct: " + accountType);
                        }


                    } else {
                        // Le mail n'existe pas, l'utilisateur doit donc s'enregistrer
                        request.setAttribute("error", "Connexion échouée,ce mail est inexistant, veuillez vous enregistrer !");

                    }

                } catch (Exception e) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/register.jsp");
            requestDisp.forward(request, response);


        }

    }
