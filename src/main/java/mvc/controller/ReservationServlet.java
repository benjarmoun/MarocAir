package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.DAO.ReservationsDAO;
import mvc.DAO.VilleDAO;
import mvc.DAO.VolsDAO;
import mvc.helpers.SendingEmail;
import mvc.metier.entities.Reservations;
import mvc.metier.entities.Ville;
import mvc.metier.entities.Vols;
import mvc.model.VilleModel;
import mvc.model.VolModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "reservation", urlPatterns = {"*.res"})

public class ReservationServlet  extends HttpServlet {
    ReservationsDAO reservationsDAO;
    VilleDAO villeDAO;

    private ArrayList<String> error = new ArrayList<>();

    public void init() throws ServletException{
        this.reservationsDAO = new ReservationsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String path = req.getServletPath();
        VolModel volModel = new VolModel();
        VilleModel villeModel = new VilleModel();
        if (path.equals("/reservations.res")) {
            PrintWriter out = resp.getWriter();

            Reservations reservations = new Reservations();

            this.error = new ArrayList<>();
            try {
                if (error.size() == 0) {
                    Cookie ck[]=req.getCookies();
                    for(int i=0;i<ck.length;i++){
                        if (ck[i].getName().equals("user")){
                            int userid = Integer.parseInt(ck[i].getValue());
                            volModel.setVols((ArrayList<Vols>) reservationsDAO.getAll(userid));
//                            villeModel.setVilles((ArrayList<Ville>) villeDAO.getAll());
                            req.setAttribute("vols", volModel.getVols());
//                            req.setAttribute("villes", villeModel.getVilles());
                            req.getRequestDispatcher("views/user/Reservations.jsp").forward(req, resp);

                        }
                    }
                }

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/add.res")) {
            PrintWriter out = resp.getWriter();

            Reservations reservations = new Reservations();
            Cookie ck[]=req.getCookies();
            for(int i=0;i<ck.length;i++){
                if (ck[i].getName().equals("user")){
                    int userid = Integer.parseInt(ck[i].getValue());
                    reservations.setUser_id(userid);
                    reservations.setVol_id(Integer.parseInt(req.getParameter("vol_id")));

                }
            }

            this.error = new ArrayList<>();
            try {
                if (error.size() == 0) {
                    if (reservationsDAO.save(reservations)) {
                        SendingEmail.send("benjarmoun123@gmail.com","Reservation confirmation","Your reservation has been done successfully ");

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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
