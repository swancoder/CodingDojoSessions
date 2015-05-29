package controller;

import model.Person;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dle on 29.05.2015.
 */
public class Crud {

  public static Person readPerson(int id) throws SQLException, ClassNotFoundException {
    Connection connection = DbUtils.establishConnection();

    ResultSet resultSet = connection.createStatement().executeQuery("select * from \"Person\"");

    return null;


  }

  public static void createPerson(){

  }

  public static void updatePerson(int id, Person person){

  }
  public static boolean deletePerson(int id){

    return false;
  }




}
