import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employee";
        String user = "root";
        String password = "admin";
        String query = "SELECT * FROM intern;";

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
            ResultSet rs =stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("Employee Details:");
                System.out.println("-------------------");
                System.out.println("ID: " + id + ", Name: " + name + ", Job Title: " + job_title + ", Salary: " + salary);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection closed successfully.");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());

        }
    }
}
