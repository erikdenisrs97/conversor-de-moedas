package com.havan.controller;

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

  public List<Operacoes> listarPorData(String dataOrigem, String dataDestino) {
    return dao.listarPorData(dataOrigem, dataDestino);
  }
  
}
