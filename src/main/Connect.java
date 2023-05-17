package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final String URL_STRING = "jdbc:mysql://localhost:3306/library_project?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String LOGIN_STRING = "bastien"; // A CHANGER
    private static final String PASSWORD_STRING = "babamotdePasse123@"; // A CHANGER

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL_STRING, LOGIN_STRING, PASSWORD_STRING);
                System.out.println("connected to database");
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database : " + e.getMessage());
            }
        }
        return connection;
    }
}
