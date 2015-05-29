package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

  public static Connection establishConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");

    Connection connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost/spike", "spike", "spike");
    return connection;
  }
}
