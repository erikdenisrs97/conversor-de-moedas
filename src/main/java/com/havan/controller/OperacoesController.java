package com.havan.controller;

import java.math.BigDecimal;
import java.util.List;

import com.havan.model.Operacoes;
import com.havan.model.dao.OperacoesDAO;

public class OperacoesController implements InterfaceController<Operacoes> {

  private OperacoesDAO dao;

  public OperacoesController() {
    dao = new OperacoesDAO();
  }

  @Override
  public Operacoes inserir(Operacoes obj) {
    return dao.inserir(obj);
  }

  @Override
  public List<Operacoes> listar() {
    return dao.listar();
  }

  public List<Operacoes> listarPorCliente(String nomeDoCliente) {
    return dao.listarPorCliente(nomeDoCliente);
  }

  public List<Operacoes> listarPorData(String dataInicio, String dataFim) {
    return dao.listarPorData(dataInicio, dataFim);
  }

  public BigDecimal valorTotal(String nomeMoeda) {
    return dao.valorTotal(nomeMoeda);
  }
  
  public BigDecimal valorTotalPorData(String nomeMoeda, String dataInicio, String dataFim) {
    return dao.valorTotalPorData(nomeMoeda, dataInicio, dataFim);
  }

  public List<Operacoes> valorTotalPorCliente(String nomeCliente) {
    return dao.valorTotalPorCliente(nomeCliente);
  }

  public BigDecimal taxaTotal(String nomeMoeda) {
    return dao.taxaTotal(nomeMoeda);
  }

  public List<Operacoes> taxaTotalPorCliente(String nomeCliente) {
    return dao.taxaTotalPorCliente(nomeCliente);
  }
  
}
