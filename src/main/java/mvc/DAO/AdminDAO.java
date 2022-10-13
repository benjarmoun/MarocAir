package mvc.DAO;

import mvc.helpers.Hash;
import mvc.model.Admin;
import mvc.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mvc.helpers.Connexion.connect;
import static mvc.helpers.Connexion.startConnection;

//import static mvc.helpers.Connexion.connect;
//import static mvc.helpers.Connexion.startConnection;

public class AdminDAO {
    public AdminDAO() throws SQLException, ClassNotFoundException {
        startConnection();
    }


    public Admin getAdmin(String username) throws SQLException {
        Admin admin = new Admin();
        PreparedStatement stmt = connect.prepareStatement("select * from admin where username = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            admin.setPassword(rs.getString("password"));
        }

        return admin;
    }

    public boolean login(Admin admin) throws Exception {


        PreparedStatement stmt = connect.prepareStatement("select * from admin where username = ?");
        stmt.setString(1, admin.getUsername());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            if (Hash.MD5(admin.getPassword()).equals(rs.getString("password")))
                return rs.getInt(1) == 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("dffdsfds");
    }
}
