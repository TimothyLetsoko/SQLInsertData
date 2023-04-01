import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //create url
        String url = "JDBC:mysql://127.0.0.1:3306/employee_database";


        try{
            System.out.print("Enter employee id:");
            int id = scanner.nextInt();

            System.out.print("Enter employee name:");
            String name = scanner.next();

            System.out.print("Enter department name:");
            String department = scanner.next();

            System.out.print("Enter salary amount:");
            double salary = scanner.nextDouble();

            //create connection
            Connection connection = DriverManager.getConnection(url,"root","Root");

            //create preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees(id, name, dept, salary) " +
                    "VALUES(?,?,?,?)");

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,department);
            preparedStatement.setDouble(4,salary);

            //execute update
            preparedStatement.executeUpdate();

            connection.close();
            scanner.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}