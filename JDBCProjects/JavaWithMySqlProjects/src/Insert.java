import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employee";
        String user = "root";
        String password = "admin";
        String query = "INSERT INTO intern (id,name, job_title, salary) VALUES (3, 'John Doe', 'Software Engineer', 60000.0);";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully."); 
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if(rowsAffected > 0) {
                System.out.println("Insert operation successful. Rows affected: " + rowsAffected);
            }
            else {
                System.out.println("No rows were inserted. Check if the ID exists.");
            }
            stmt.close();
            conn.close();
            System.out.println("Connection closed successfully.");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());

        }
    }
}
