package main;

import controller.Crud;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;

import java.sql.SQLException;

/**
 * Created by dle on 29.05.2015.
 */
public class Main {
  public static void main(String[] args) throws SQLException {
    TJWSEmbeddedJaxrsServer tjws = new TJWSEmbeddedJaxrsServer();
    tjws.setPort(8080);
    tjws.start();
    tjws.getDeployment().getRegistry().addPerRequestResource(Crud.class);
  }


}
