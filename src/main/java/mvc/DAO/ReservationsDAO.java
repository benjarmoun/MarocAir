package mvc.DAO;

import mvc.DAO.repository.DAO;
import mvc.metier.entities.Reservations;
import mvc.metier.entities.Vols;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static mvc.helpers.Connexion.getConnection;

public class ReservationsDAO implements DAO<Reservations> {

    public boolean addReservation(Reservations reservation) {
        return false;
    }

    @Override
    public Reservations get(int id) {
        return null;
    }

    @Override
    public List<Reservations> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<Vols> getAll(int user_id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("SELECT  vol.id, vd.nom ville_depart, va.nom ville_arriver, date_dep, date_arr FROM `reservation`  JOIN vol on vol_id= vol.id  join villes vd on vol.id_depart = vd.id join villes va on va.id = vol.id_arrive WHERE user_id=?");
        stm.setInt(1, user_id);
        ResultSet rs = stm.executeQuery();
        List<Vols> res = new ArrayList<>();
        while (rs.next()){
            Vols vol = new Vols();
            vol.setnVille_dep(rs.getString("ville_depart"));
            vol.setnVille_arr(rs.getString("ville_arriver"));
            vol.setDate_dep(rs.getString("date_dep"));
            vol.setDate_arr(rs.getString("date_arr"));

            res.add(vol);
        }
        return res;

    }

    @Override
    public boolean save(Reservations reservations) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("INSERT INTO marocair.reservation (vol_id, user_id,date_Voyage)VALUES (?, ?,?)");
        stm.setInt(1, reservations.getVol_id());
        stm.setInt(2, reservations.getUser_id());
        stm.setString(3, reservations.getDateVoyage());
        return stm.executeUpdate() != 0;
    }

    @Override
    public void update(Reservations reservations, int i) {

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
