package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.VilleDAO;
import mvc.DAO.VolsDAO;
import mvc.metier.entities.Ville;
import mvc.metier.entities.Vols;
import mvc.model.VilleModel;
import mvc.model.VolModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "vol", urlPatterns = {"*.vol"})

public class VolServlet extends HttpServlet {
    VolsDAO volsDAO;
    VilleDAO villeDAO;

    @Override
    public void init() throws ServletException {
        try {
            this.volsDAO = new VolsDAO();
            this.villeDAO = new VilleDAO();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        VolModel volModel = new VolModel();
        VilleModel villeModel = new VilleModel();

        if (path.equals("/dashboard.vol")) {
            try {
                volModel.setVols((ArrayList<Vols>) volsDAO.getAll());
                villeModel.setVilles((ArrayList<Ville>) villeDAO.getAll());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("vols", volModel.getVols());
            req.setAttribute("villes", villeModel.getVilles());
            req.getRequestDispatcher("views/admin/Dashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
