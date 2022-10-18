package mvc.DAO;

import mvc.DAO.repository.DAO;
import mvc.metier.entities.Reservations;
import mvc.metier.entities.Vols;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public boolean save(Reservations reservations) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("INSERT INTO marocair.reservation (vol_id, user_id)VALUES (?, ?)");
        stm.setInt(1, reservations.getVol_id());
        stm.setInt(2, reservations.getVol_id());
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
