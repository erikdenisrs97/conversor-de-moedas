package com.havan.controller;

import java.util.List;

import com.havan.model.Moeda;
import com.havan.model.dao.MoedaDAO;

public class MoedaController implements InterfaceController<Moeda> {

  private MoedaDAO dao;

  MoedaController() {
    dao = new MoedaDAO();
  }

  @Override
  public Moeda inserir(Moeda obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Moeda> listar() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
