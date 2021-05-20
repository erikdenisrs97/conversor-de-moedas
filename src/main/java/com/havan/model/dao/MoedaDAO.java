package com.havan.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.havan.model.Moeda;

public class MoedaDAO implements InterfaceDAO<Moeda> {

  @Override
  public Moeda inserir(Moeda obj) {
    try {
    Connection conn = ConnectionDatabase.getConnection();
    String nomeMoeda = obj.getNomeMoeda();
    String unidadeMonetaria = obj.getUnidadeMonetaria();
    BigDecimal valor = obj.getValor();
    /* Query */
    String query = "INSERT INTO moedas(nome, unidade_monetaria, valor) VALUES (?, ?, ?);";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, nomeMoeda);
    ps.setString(2, unidadeMonetaria);
    ps.setBigDecimal(3, valor);
    ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return obj;
  }

  @Override
  public List<Moeda> listar() {
    List<Moeda> moedas = new ArrayList<Moeda>();
    try {
      Connection conn = ConnectionDatabase.getConnection();
      Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT * FROM moedas");
      while(result.next()) {
        String nome = result.getString("nome");
        String unidadeMonetaria = result.getString("unidade_monetaria");
        BigDecimal valor = result.getBigDecimal("valor");
        moedas.add(new Moeda(nome, unidadeMonetaria, valor));
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return moedas;
  }
  
}
