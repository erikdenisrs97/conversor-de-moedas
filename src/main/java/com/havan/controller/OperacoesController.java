package com.havan.controller;

import java.util.List;

import com.havan.model.Operacoes;
import com.havan.model.dao.OperacoesDAO;

public class OperacoesController implements InterfaceController<Operacoes> {

  private OperacoesDAO dao;

  OperacoesController() {
    dao = new OperacoesDAO();
  }

  @Override
  public Operacoes inserir(Operacoes obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Operacoes> listar() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
