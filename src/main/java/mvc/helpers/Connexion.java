package mvc.helpers;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {


    public static Connection connect;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String DATA_BASE = "test3";
    private static final int PORT = 3306;
    private static final String URL = "jdbc:mysql://localhost:3306/marocair";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void startConnection() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName(DRIVER);

        connect = DriverManager.getConnection(URL, "root", "");
    }
}


