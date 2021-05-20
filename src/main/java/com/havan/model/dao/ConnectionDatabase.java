package com.havan.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.havan.controller.Propriedades;

public class ConnectionDatabase {

  public static final String DRIVER = Propriedades.get("bd.driver");
  public static final String URL = Propriedades.get("bd.url");
  public static final String USER = Propriedades.get("bd.usuario");
  public static final String PASSWORD = Propriedades.get("bd.senha");

  /* Estabelece conexão com o banco de dados. */
  public static Connection getConnection() {
    try {
      Class.forName("org.postgresql.Driver");
      return DriverManager.getConnection("jdbc:postgresql://localhost:5432/havantechlabs", "erikdenis", "1234");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
}