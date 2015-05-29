package controller;

import model.Person;
import utils.DbUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dle on 29.05.2015.
 */
@Path("/person")
public class Crud {

  public static final String APPLICATION_JSON = "application/json";

  @Path("/{id}")
  @GET
  @Produces(APPLICATION_JSON)
  public static Person readPerson(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
    Connection connection = DbUtils.establishConnection();

    ResultSet resultSet = connection.createStatement().executeQuery("select * from \"Person\" where id = " + id);
    Person person = null;
    if(resultSet.next()) {
      person = new Person(resultSet.getInt(1), resultSet.getString(2));
    }

    connection.close();
    return person;
  }

  @Path("/")
  @POST
  @Consumes(APPLICATION_JSON)
  @Produces(APPLICATION_JSON)
  public static Person createPerson(Person person) throws SQLException, ClassNotFoundException {
    Connection connection = DbUtils.establishConnection();
    connection.createStatement().executeUpdate("insert into \"Person\" (id, name) values ("
        + person.getId() + ", '" + person.getName() + "')") ;
    connection.close();
    return person;
  }

  @Path("/{id}")
  @POST
  @Consumes(APPLICATION_JSON)
  @Produces(APPLICATION_JSON)
  public static Person updatePerson(@PathParam("id")int id, Person person) throws SQLException, ClassNotFoundException {
    Connection connection = DbUtils.establishConnection();
    connection.createStatement().executeUpdate("update \"Person\" set name = '" + person.getName() + "' where id = " + id);
    connection.close();
    person.setId(id);
    return person;
  }

  @Path("/{id}")
  @DELETE
  public static boolean deletePerson(@PathParam("id")int id) throws SQLException, ClassNotFoundException {
    Connection connection = DbUtils.establishConnection();
    int count = connection.createStatement().executeUpdate("delete from \"Person\" where id = " + id);
    connection.close();
    return (count == 1);
  }
}