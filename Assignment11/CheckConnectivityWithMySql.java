/* 
 Class to check connectivity with a MySQL database using JDBC.
 It establishes a connection to a specified database 
 using the provided URL, username, and password from user input.

 If the connection is successful, it prints a success message, 
 otherwise it handles SQLException and prints error details.

 Author: Akshay Basak
 Date: 10-09-2025
*/

package Assignment11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckConnectivityWithMySql {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter MySQL server address (e.g., 127.0.0.1): ");
        String server = sc.nextLine();

        System.out.print("Enter MySQL port (default 3306): ");
        String port = sc.nextLine();
        if (port.trim().isEmpty()) port = "3306";

        System.out.print("Enter database name: ");
        String dbName = sc.nextLine();

        System.out.print("Enter MySQL username: ");
        String user = sc.nextLine();

        System.out.print("Enter MySQL password: ");
        String password = sc.nextLine();

        String url = "jdbc:mysql://" + server + ":" + port + "/" + dbName;     
 

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
        finally {
            sc.close();
        }
    }
}
