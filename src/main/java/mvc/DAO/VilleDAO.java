package mvc.DAO;

import mvc.model.Ville;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.startConnection;

public class VilleDAO {
    public VilleDAO() throws SQLException, ClassNotFoundException {

        startConnection();
    }


    public List<Ville> getAllVilles() throws SQLException {
        List<Ville> villes = new ArrayList<Ville>();
        PreparedStatement stm = connect.prepareStatement("select * from villes");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            villes.add(new Ville(rs.getInt("id"),rs.getString("nom")));
        }

        return villes;
    }


    public Ville getVille(int id) {
        Ville ville = new Ville();
        PreparedStatement stm = connect.prepareStatement("select * ville from villes where nom");


        return new Ville();
    }

}
