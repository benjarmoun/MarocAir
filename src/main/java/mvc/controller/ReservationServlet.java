package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.ReservationsDAO;
import mvc.DAO.VilleDAO;
import mvc.DAO.VolsDAO;
import mvc.metier.entities.Reservations;
import mvc.metier.entities.Vols;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "reservation", urlPatterns = {"*.res"})

public class ReservationServlet  extends HttpServlet {
    ReservationsDAO reservationsDAO;
    private ArrayList<String> error = new ArrayList<>();

    public void init() throws ServletException{
        this.reservationsDAO = new ReservationsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String path = req.getServletPath();
        if (path.equals("/add.res")) {
            PrintWriter out = resp.getWriter();

            Reservations reservations = new Reservations();
            reservations.setVol_id(Integer.parseInt(req.getParameter("vol_id")));
            reservations.setUser_id(Integer.parseInt(req.getParameter("user_id")));
            this.error = new ArrayList<>();
            try {
                if (error.size() == 0) {
                    if (reservationsDAO.save(reservations)) {
                        resp.sendRedirect("/dashboardUser.vol");
                        this.error = new ArrayList<>();
                    }
                } else {

                    resp.sendRedirect("/dashboardUser.vol");

                }

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
