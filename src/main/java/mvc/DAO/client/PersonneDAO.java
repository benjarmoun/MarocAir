package mvc.DAO.client;

import mvc.model.client.Personne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.startConnection;

//import static mvc.helpers.Connexion.connect;
//import static mvc.helpers.Connexion.startConnection;

public class PersonneDAO {
    public PersonneDAO() {
    }

    public boolean login(Personne personne) throws SQLException, ClassNotFoundException {

        startConnection();
        PreparedStatement stmt = connect.prepareStatement("select count(*) from admin where username = ? and password = ?");

        stmt.setString(1, personne.getUsername());
        stmt.setString(2, personne.getPassword());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) == 1;
        }
        return false;
    }
}
