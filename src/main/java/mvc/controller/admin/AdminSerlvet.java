package mvc.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.AdminDAO;
import mvc.model.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//@WebServlet()


public class AdminSerlvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = new Admin();
        AdminDAO adminDAO = null;
        admin.setUsername(req.getParameter("username"));
        admin.setPassword(req.getParameter("password"));

        try {
            adminDAO = new AdminDAO();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pr = resp.getWriter();

        try {
            if (adminDAO.login(admin)) {
                pr.println("true");
            } else pr.println("false");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
