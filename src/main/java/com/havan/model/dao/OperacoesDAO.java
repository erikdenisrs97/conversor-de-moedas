package com.havan.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.havan.model.Operacoes;

public class OperacoesDAO implements InterfaceDAO<Operacoes> {

  @Override
  public Operacoes inserir(Operacoes obj) {
    try {
      Connection conn = ConnectionDatabase.getConnection();
      String nomeCliente = obj.getNomeCliente();
      String moedaOrigem = obj.getMoedaOrigem();
      String moedaDestino = obj.getMoedaDestino();
      String dataOperacao = obj.getData();
      BigDecimal valorOriginal = obj.getValorOriginal();
      BigDecimal valorConvertido = obj.getValorConvertido();
      BigDecimal taxaCobrada = obj.getTaxaCobrada();
      String query = "INSERT INTO operacoes(nome_cliente, moeda_origem, moeda_destino, data_operacao, valor_original, valor_convertido, taxa_cobrada) VALUES (?, ?, ?, ?, ?, ?, ?);";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, nomeCliente);
      ps.setString(2, moedaOrigem);
      ps.setString(3, moedaDestino);
      ps.setDate(4, new Date(622790105000L));
      ps.setBigDecimal(5, valorOriginal);
      ps.setBigDecimal(6, valorConvertido);
      ps.setBigDecimal(7, taxaCobrada);
      ps.execute();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Operacoes> listar() {
    Connection conn = ConnectionDatabase.getConnection();
    List<Operacoes> ops = new ArrayList<Operacoes>();
    try {
      Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT * FROM operacoes");
      while(result.next()) {
        Integer id = result.getInt("id");
        String nomeCliente = result.getString("nome_cliente");
        String moedaOrigem = result.getString("moeda_origem");
        String moedaDestino = result.getString("moeda_destino");
        String dataOperacao = result.getString("data_operacao");
        BigDecimal valorOriginal = result.getBigDecimal("valor_original");
        BigDecimal valorConvertido = result.getBigDecimal("valor_convertido");
        BigDecimal taxaCobrada = result.getBigDecimal("taxa_cobrada");
        ops.add(new Operacoes(nomeCliente, moedaOrigem, moedaDestino, dataOperacao,
         valorOriginal, valorConvertido, taxaCobrada));
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ops;
  }
  
}
