package mvc.DAO;

import mvc.metier.entities.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.getConnection;

public class VilleDAO {
    public VilleDAO() throws SQLException, ClassNotFoundException {

    }


    public List<Ville> getAllVilles() throws SQLException, ClassNotFoundException {
        Connection connect = getConnection();

        List<Ville> villes = new ArrayList<Ville>();
        PreparedStatement stm = connect.prepareStatement("select * from villes");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            villes.add(new Ville(rs.getInt("id"), rs.getString("nom")));
        }

        return villes;
    }


    public Ville getVille(int id) throws SQLException {
        Ville ville = new Ville();
        PreparedStatement stm = connect.prepareStatement("select * ville from villes where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
           ville.setId(rs.getInt("id"));
           ville.setNom(rs.getString("nom"));
        }

        return null;
    }

}
