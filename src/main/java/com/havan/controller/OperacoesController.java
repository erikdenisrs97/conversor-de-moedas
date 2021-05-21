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

  @Override
  public Operacoes procuraPorId(int id) {
    return dao.procuraPorId(id);
  }
  
}
