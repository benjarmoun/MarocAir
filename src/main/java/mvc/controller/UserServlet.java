package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.AdminDAO;
import mvc.DAO.UserDAO;
import mvc.metier.entities.Admin;
import mvc.metier.entities.User;

import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.us")) {
            req.getRequestDispatcher("views/user/login.jsp").forward(req, resp);
        }
        if (path.equals("/register.us")){
            req.getRequestDispatcher("views/user/register.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.us")) {

            User user = new User();
            UserDAO userDAO = null;
            user.setEmail(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));

            userDAO = new UserDAO();
            PrintWriter pr = resp.getWriter();

            try {
                if (userDAO.login(user)) {
                    resp.sendRedirect("/dashboard.vol");
//                    req.getRequestDispatcher("views/admin/Dashboard.jsp").forward(req, resp);

                } else pr.println("false");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            if (path.equals("/register.us")){
                User user = new User();
                UserDAO userDAO = null;
                user.setFname(req.getParameter("fname"));
                user.setLname(req.getParameter("lname"));
                user.setEmail(req.getParameter("email"));
                user.setPassword(req.getParameter("password"));

                userDAO = new UserDAO();
                PrintWriter pr = resp.getWriter();

                try {
                    if (userDAO.register(user)) {
                        resp.sendRedirect("/login.us");

                    } else pr.println("fals");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }



    }
}
