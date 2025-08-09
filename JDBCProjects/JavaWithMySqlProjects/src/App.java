import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/company"; // Change your_database
        String user = "root"; // Change your_username
        String password = "admin"; // Change your_password

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