package mvc.controller.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.client.PersonneDAO;
import mvc.model.client.Personne;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//@WebServlet()


public class PesonneSerlvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Personne p1 = new Personne();
        p1.setUsername(req.getParameter("username"));
        p1.setPassword(req.getParameter("password"));
        PersonneDAO pO = new PersonneDAO();
        PrintWriter pr=resp.getWriter();

        try {
            if (pO.login(p1)) {
            pr.println("true");
            }else pr.println("fasle");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
