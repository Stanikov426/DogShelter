package pl.stanikov.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

import com.mysql.jdbc.Driver;
 
public class ConnectionProvider {
        
    public static final String URL = "jdbc:mysql://localhost:3306/shelter_app";
    public static final String USER = "root";
    public static final String PASS = "admin";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
      try {
          DriverManager.registerDriver(new Driver());
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Nie polaczono sie z baza danych :(", ex);
      }
    }
}
