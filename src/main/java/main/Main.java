package main;

import model.Person;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dle on 29.05.2015.
 */
public class Main {
  public static void main(String[] args) throws SQLException {
    System.out.println(" test");
    Connection connection = null;
    try {
      connection = DbUtils.establishConnection();

      ResultSet resultSet = connection.createStatement().executeQuery("select * from \"Person\"");
      while(resultSet.next()) {
        System.out.println(" Result "+resultSet.getInt(1)+" -" +resultSet.getString(2));
      }
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }


}
