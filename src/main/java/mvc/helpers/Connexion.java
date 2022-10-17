package mvc.helpers;
//import io.github.cdimascio.dotenv.Dotenv;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {


    public static Connection connect;
//    static Dotenv dotenv = Dotenv.load();

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String DATA_BASE = "test3";
    private static final int PORT = 3306;
    private static final String URL = "jdbc:mysql://localhost:3306/marocair";
    private static final String USER = "root";
    private static final String PASS = "";


    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connect = DriverManager.getConnection(URL, "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException, SQLException {
        return connect;

    }
}


