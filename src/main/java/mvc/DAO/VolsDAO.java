package mvc.DAO;

import mvc.DAO.repository.DAO;
import mvc.metier.entities.Vols;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static mvc.helpers.Connexion.getConnection;


public class VolsDAO implements DAO<Vols> {

    public VolsDAO() throws SQLException, ClassNotFoundException {

    }

    public boolean addVol(Vols vol) {
        return false;
    }

    @Override
    public Vols get(int id) {
        return null;
    }

    @Override
    public List<Vols> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Vols vols) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("INSERT INTO marocair.vol (date_dep, date_arr, nbr_place, prix, id_depart, id_arrive)VALUES (?, ?, ?, ?, ?, ?)");
        stm.setTime(1, vols.getDate_dep());
        stm.setTime(2, vols.getDate_arr());
        stm.setInt(3, vols.getNbr_place());
        stm.setFloat(4, vols.getPrix());
        stm.setInt(5, vols.getVille_dep());
        stm.setInt(6, vols.getVille_arr());
        return stm.executeUpdate() != 0;
    }

    @Override
    public void update(Vols vols, int i) {


    }

    @Override
    public void delete(long id) {

    }
}
