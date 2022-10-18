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
    public Admin login(Admin admin) throws Exception {
        Connection connect = getConnection();
        PreparedStatement stmt = connect.prepareStatement("select * from admin where username = ?");
        stmt.setString(1, admin.getUsername());
        ResultSet rs = stmt.executeQuery();
        Admin admin1=new Admin();
        if (rs.next()) {
            if (Hash.MD5(admin.getPassword()).equals(rs.getString("password")))
                admin1.setUsername(rs.getString("username"));
            return admin1;
        }
        return null;
    }

    @Override
    public boolean register(Admin admin) {
        return false;
    }
}
