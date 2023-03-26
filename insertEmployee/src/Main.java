import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //create url
        String url = "JDBC:mysql://127.0.0.1:3306/employee_database";


        try {
            //get connection
            Connection conn = DriverManager.getConnection(url,"root","Root");

            //create statement
            Statement statement = conn.createStatement();

            //execute query
            int rowsAffected = statement.executeUpdate("INSERT INTO employees(name, dept, salary) " +
                    "VALUES('France', 'Sales',10000)");
            System.out.println("Insertion success, "+rowsAffected+" affected.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}