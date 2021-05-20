package com.havan.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.havan.model.Operacoes;

public class OperacoesDAO implements InterfaceDAO<Operacoes> {

  @Override
  public void inserir(Operacoes obj) {
    // TODO Auto-generated method stub
  }

  @Override
  public List<Operacoes> listar() {
    Connection conn = ConnectionDatabase.getConnection();
    List<Operacoes> ops = new ArrayList<Operacoes>();
    try {
      Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT * FROM operacoes");
      while(result.next()) {
        int id = result.getInt("id");
        String nomeCliente = result.getString("nome_cliente");
        String moedaOrigem = result.getString("moeda_origem");
        String moedaDestino = result.getString("moeda_destino");
        String dataOperacao = result.getString("data_operacao");
        BigDecimal valorOriginal = result.getBigDecimal("valor_original");
        BigDecimal valorConvertido = result.getBigDecimal("valor_convertido");
        BigDecimal taxaCobrada = result.getBigDecimal("taxa_cobrada");
        ops.add(new Operacoes(id, nomeCliente, moedaOrigem, moedaDestino, dataOperacao,
         valorOriginal, valorConvertido, taxaCobrada));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
}
