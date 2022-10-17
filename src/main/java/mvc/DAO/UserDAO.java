package mvc.DAO;

import com.mysql.cj.xdevapi.Client;
import mvc.DAO.repository.Auth;
import mvc.helpers.Hash;
import mvc.metier.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static mvc.helpers.Connexion.getConnection;

public class UserDAO implements Auth<User> {
    @Override
    public boolean login(User user) throws Exception {
        Connection connect = getConnection();
        PreparedStatement stmt = connect.prepareStatement("select * from user where email = ?");
        stmt.setString(1, user.getEmail());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            if (Hash.MD5(user.getPassword()).equals(rs.getString("password")))
                return true;
        }
        return false;

    }



}
