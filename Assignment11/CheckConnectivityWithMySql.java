package Assignment11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnectivityWithMySql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/company"; 
        String user = "root"; 
        String password = "admin"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to MySQL successfully!");
            } else {
                System.out.println("Failed to connect to MySQL.");
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed!");
            e.printStackTrace();
        }
    }
}
