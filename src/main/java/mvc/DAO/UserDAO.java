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


}
