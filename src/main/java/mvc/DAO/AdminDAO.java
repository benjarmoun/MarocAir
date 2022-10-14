package mvc.DAO;

import mvc.DAO.repository.Auth;
import mvc.helpers.Hash;
import mvc.metier.entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.getConnection;

//import static mvc.helpers.Connexion.connect;
//import static mvc.helpers.Connexion.startConnection;

public class AdminDAO implements Auth<Admin> {
    @Override
    public boolean login(Admin admin) throws Exception {
        Connection connect = getConnection();
        PreparedStatement stmt = connect.prepareStatement("select * from admin where username = ?");
        stmt.setString(1, admin.getUsername());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            if (Hash.MD5(admin.getPassword()).equals(rs.getString("password")))
                return rs.getInt(1) == 1;
        }
        return false;
    }

    @Override
    public boolean register(Admin admin) {
        return false;
    }
}
