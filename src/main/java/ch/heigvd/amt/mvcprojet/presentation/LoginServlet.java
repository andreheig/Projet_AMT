            package ch.heigvd.amt.mvcprojet.presentation;

            import ch.heigvd.amt.mvcprojet.database.IDevelopperDAOLocal;
            import ch.heigvd.amt.mvcprojet.database.IUserDAOLocal;
            import ch.heigvd.amt.mvcprojet.model.User;

            import javax.ejb.EJB;
            import javax.servlet.RequestDispatcher;
            import javax.servlet.ServletConfig;
            import javax.servlet.ServletException;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
            import javax.servlet.http.HttpSession;
            import java.io.IOException;

            public class LoginServlet extends javax.servlet.http.HttpServlet {


                @EJB
                private IUserDAOLocal userDAO;

                @EJB
                private IDevelopperDAOLocal devDAO;

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
                    // Recherche si le mail existe déjà dans la DB!
                    User user = userDAO.loadUser(email);

                    boolean emailOK = false;
                    boolean passOK = false;

                    // Test presence d'un mot dans le champ mail
                    if (email.isEmpty()) {
                        request.setAttribute("emailNull", "Email manquant");
                    }else if (!email.contains("@") || !email.contains(".")){
                        request.setAttribute("emailInccorect", "Syntaxe eronné");
                    }else{
                        emailOK = true;
                    }


                    // Test password
                    if (password.isEmpty()) {
                        request.setAttribute("passwordNull", "Mot de passe manquant");

                    } else {
                        passOK = true;
                    }


                    if (emailOK && passOK){


                        //verifie si le user existe
                        //if (userDAO.userExist(user)){
                        if(userDAO.loadUser(email) != null){

                            //verifie si le password est correct
                            if (userDAO.loginMatch(user, password)) {

                                // Le mail existe, l'utilisateur est autorisé
                                HttpSession session = request.getSession();
                                session.setAttribute("user", userDAO.setUserSession(user));
                                final String accountType = user.getAccountType();

                                //verification du type de compte
                                if ("admin".equals(accountType)) {
                                    response.sendRedirect("/Projet_AMT/admin");
                                    return;
                                } else if ("dev".equals(accountType)) {

                                    //si le dev est suspendu
                                    if (devDAO.isDeveloperSuspended(user.getUserId())) {

                                        request.setAttribute("error", "Vous avez été suspendu, veuillez contacter votre Admin !");

                                    } else if (devDAO.hasToResetPassword(user)) { //si le dev doit reset son mdp

                                        response.sendRedirect("/Projet_AMT/changePass");
                                        return;

                                    } else {
                                        response.sendRedirect("/Projet_AMT/dev");
                                        return;

                                    }

                                }
                            }else{
                                request.setAttribute("passwordNotFound", "Votre mot de passe n'est pas valide ! ");
                            }



                        }else {

                            request.setAttribute("EmailNotExist", "Votre email n'est pas existante ! veuilez vous enregistrer.");
                            response.sendRedirect("/Projet_AMT/register");
                            return;
                        }


                    }

                    User userlog = new User("", "", email, password, "");
                    request.setAttribute("user", userlog);

                    RequestDispatcher requestDisp = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp");
                    requestDisp.forward(request, response);

                }

            }
