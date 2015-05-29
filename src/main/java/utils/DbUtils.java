package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

  public static Connection establishConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    Connection connection = null;
    connection = DriverManager.getConnection(
        "jdbc:postgresql://hostname:port/dbname", "username", "password");
//    connection.close();
    return connection;
  }
}
