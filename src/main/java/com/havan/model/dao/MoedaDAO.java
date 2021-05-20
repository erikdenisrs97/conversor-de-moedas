package com.havan.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.havan.model.Moeda;

public class MoedaDAO implements InterfaceDAO<Moeda> {

  @Override
  public Moeda inserir(Moeda obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Moeda> listar() {
    List<Moeda> moedas = new ArrayList<Moeda>();
    try {
      Connection conn = ConnectionDatabase.getConnection();
      Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT * FROM moedas");
      while(result.next()) {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String unidadeMonetaria = result.getString("unidade_monetaria");
        String valor = result.getString("valor");
        moedas.add(new Moeda(id, nome, unidadeMonetaria, valor));
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return moedas;
  }
  
}
