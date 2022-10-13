package mvc.DAO;

import mvc.model.Vols;

import java.sql.SQLException;

import static mvc.helpers.Connexion.startConnection;

public class VolsDAO {

    public VolsDAO() throws SQLException, ClassNotFoundException {
        startConnection();

    }

    public boolean addVol(Vols vol) {
        return false;
    }
}
