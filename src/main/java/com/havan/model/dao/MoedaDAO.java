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
  public void inserir(Moeda obj) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void editar(Moeda obj) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deletar(Moeda obj) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Moeda buscarPorID(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Moeda> listar() {
    Connection conn = ConnectionDatabase.getConnection();
    List<Moeda> moedas = new ArrayList<>();
    try {
      Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT * FROM moedas");
      while(result.next()) {
        // Mostrar na tela o que será recuperado
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
}
