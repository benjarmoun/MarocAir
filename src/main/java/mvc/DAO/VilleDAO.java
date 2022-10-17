package mvc.DAO;

import mvc.DAO.repository.DAO;
import mvc.metier.entities.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.getConnection;

public class VilleDAO implements DAO<Ville> {
    public VilleDAO() throws SQLException, ClassNotFoundException {

    }

    @Override
    public Ville get(int id) {
        return null;
    }

    @Override
    public List<Ville> getAll() throws SQLException, ClassNotFoundException {

        Connection connect = getConnection();
        List<Ville> villes = new ArrayList<Ville>();
        PreparedStatement stm = connect.prepareStatement("select * from villes");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            villes.add(new Ville(rs.getInt("id"), rs.getString("nom")));
        }
        return villes;
    }

    @Override
    public boolean save(Ville ville) {
        return false;
    }

    @Override
    public void update(Ville ville, int i) {

    }

    @Override
    public boolean delete(int id) {
return false;
    }
}
