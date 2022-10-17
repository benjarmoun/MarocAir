package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.AdminDAO;
import mvc.metier.entities.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "admin", urlPatterns = {"*.ad"})


public class AdminSerlvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.ad")) {
            req.getRequestDispatcher("views/admin/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.ad")) {
            Admin admin = new Admin();
            AdminDAO adminDAO = null;
            admin.setUsername(req.getParameter("username"));
            admin.setPassword(req.getParameter("password"));
            adminDAO = new AdminDAO();
            PrintWriter pr = resp.getWriter();
            try {
                if (adminDAO.login(admin)) {
                    resp.sendRedirect("/dashboard.vol");
//                    req.getRequestDispatcher("views/admin/Dashboard.jsp").forward(req, resp);

                } else pr.println("false");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


    }
}
