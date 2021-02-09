package models;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = System.getenv("PATH");
    public static final String USER = System.getenv("USERNAME");
    public static  final String PASS = System.getenv("PASSWORD");

    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) {






    }

}
