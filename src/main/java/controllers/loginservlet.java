package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

//paht

@WebServlet({"/login", "/login.html"})

public class loginservlet extends HttpServlet {

    //CONTANTES NO CAMBIAN STATIC
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        //busco en  el arreglo de cookie si existe la cookie
        //solicitada y la convierto en String
        Optional<String> cookieOptional = Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName()))
                //convertimos a string el valor encontrado
                .map(Cookie::getValue)
                .findAny();
        if (cookieOptional.isPresent()) {
            resp.setContentType("text/html");
           try(PrintWriter out = resp.getWriter()) {

               //escrbimos la respuesta en html

               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<meta charset='UTF-8'>");
               out.println("<title>Saludando desde el Servlet</title>");
               out.println("</head>");
               out.println("<body>");
               out.println("<h1>Hola "+cookieOptional.get()+" ya iniciaste sesión anteriormente!</h1>");
               out.println("<p><a href='" + req.getContextPath() + "/index.html'>Volver al Inicio</a></p>");
               out.println("</body>");
               out.println("</html>");
           }

        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {

                //Creamos la cookie
                Cookie usernameCookie = new Cookie("username", username);
                resp.addCookie(usernameCookie);

                resp.setContentType("text/html;charset=UTF-8");

                try (PrintWriter out = resp.getWriter()) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta charset='UTF-8'>");
                    out.println("<title>Bienvenido</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Bienvenido APP</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    resp.sendRedirect(req.getContextPath()+"/login.html");
                }
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no tiene acceso");
            }
        }
}
