package mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
import java.sql.Time;
import java.util.ArrayList;

@WebServlet(name = "vol", urlPatterns = {"*.vol"})

public class VolServlet extends HttpServlet {
    VolsDAO volsDAO;
    VilleDAO villeDAO;
    private ArrayList<String> error = new ArrayList<>();


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
        int testCokie = 0;
        if (path.equals("/dashboard.vol")) {

            Cookie[] ck = req.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("admin")) {
                        testCokie++;
                    }
                }
            }
            if (testCokie == 0) {

                resp.sendRedirect("/login.ad");
            } else {


                try {
                    volModel.setVols((ArrayList<Vols>) volsDAO.getAll());
                    villeModel.setVilles((ArrayList<Ville>) villeDAO.getAll());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("vols", volModel.getVols());
                req.setAttribute("villes", villeModel.getVilles());
                req.setAttribute("erreur", error);
                req.getRequestDispatcher("views/admin/Dashboard.jsp").forward(req, resp);
            }


            //delete vols
        } else if (path.equals("/delete.vol")) {
            try {
                if (volsDAO.delete(Integer.parseInt(req.getParameter("id")))) {
                    resp.sendRedirect("/dashboard.vol");

                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
//            out.println(req.getParameter("id"));
        } else if (path.equals("/dashboardUser.vol")) {
            PrintWriter out = resp.getWriter();


            if (req.getParameter("depart") != null) {

                int depart = Integer.parseInt(req.getParameter("depart"));
                int arrive = Integer.parseInt(req.getParameter("arrive"));
                String dateVoyage = req.getParameter("dated");
                req.setAttribute("dateVoyage", dateVoyage);


                try {
                    volModel.setVols((ArrayList<Vols>) volsDAO.getAll(depart, arrive));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        }


        try {

            villeModel.setVilles((ArrayList<Ville>) villeDAO.getAll());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("vols", volModel.getVols());
        req.setAttribute("villes", villeModel.getVilles());
        req.setAttribute("erreur", error);
        req.getRequestDispatcher("views/client/DashboardUser.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/add.vol")) {
            PrintWriter out = resp.getWriter();

            Vols vols = new Vols();
            vols.setDate_dep(req.getParameter("heure_dep"));
            vols.setDate_arr(req.getParameter("heure_arr"));
            vols.setPrix(Float.parseFloat(req.getParameter("prix")));
            vols.setNbr_place(Integer.parseInt(req.getParameter("nbr_place")));
            vols.setVille_dep(Integer.parseInt(req.getParameter("ville_dep")));
            vols.setVille_arr(Integer.parseInt(req.getParameter("ville_arr")));
            this.error = new ArrayList<>();
//            out.println(req.getParameter("heure_dep"));
            try {

                if (req.getParameter("ville_dep").equals(req.getParameter("ville_arr"))) {

                    error.add("la ville de depart doit être different de la ville d'arriver");
                }
                if (req.getParameter("heure_dep").equals(req.getParameter("heure_arr"))) {
                    error.add("l'heure de depart doit être different de l'heure d'arriver");

                }


                if (error.size() == 0) {
                    if (volsDAO.save(vols)) {
                        resp.sendRedirect("/dashboard.vol");
                        this.error = new ArrayList<>();
                    }
                } else {

                    resp.sendRedirect("/dashboard.vol");

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

    }
}
