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

    @Override
    public boolean register(User user) throws Exception{
        Connection connect = getConnection();
        PreparedStatement stmt = connect.prepareStatement("INSERT INTO `user`(`fname`, `lname`, `email`, `password`) " +
                "VALUES (?,?,?,?)");
        stmt.setString(1, user.getFname());
        stmt.setString(2, user.getLname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, Hash.MD5(user.getPassword()));
//        ResultSet rs = stmt.executeUpdate();

        if (stmt.executeUpdate() == 1) {
            return true;
        }
        return false;
    }


}
