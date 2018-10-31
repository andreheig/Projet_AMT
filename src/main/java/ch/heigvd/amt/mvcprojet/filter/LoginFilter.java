package ch.heigvd.amt.mvcprojet.filter;

import ch.heigvd.amt.mvcprojet.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    private ServletContext context;

    public void init( FilterConfig config ) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if(path.startsWith("/static")){
            // Permet de savoir que l'on souhaite accéder au feuilles de style
            chain.doFilter(httpRequest, httpResponse);
            return;
        }
        // Permet de laisser passer s'il l'on veux se loguer ou s'enregistrer
        if(path.contains("login") || path.contains("register") || path.contains("home")){
            chain.doFilter(httpRequest, httpResponse);
            return;
        }
        User user = (User) httpRequest.getSession().getAttribute("user");
        if(user == null){
            httpRequest.getRequestDispatcher( "/home" ).forward( httpRequest, httpResponse );
        }
        // Permet de checher que l'on est developpeur
        else if(user.getAccountType().contains("dev")){
            // test si l'on tente d'accéder à une page admin
            // TODO : il serait bien de signaler que l'adresse est verboten!
            if(path.contains("admin")){
                httpRequest.getRequestDispatcher( "/dev" ).forward( httpRequest, httpResponse );
            }
            else{
                chain.doFilter(httpRequest, httpResponse);
            }
        }
        else{
            chain.doFilter(httpRequest, httpResponse);
        }
    }


    public void destroy() {

    }
}
