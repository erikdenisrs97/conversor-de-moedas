package com.havan.controller;

import java.util.List;

import com.havan.model.Moeda;
import com.havan.model.dao.MoedaDAO;

public class MoedaController implements InterfaceController<Moeda> {

  private MoedaDAO dao;

  public MoedaController() {
    dao = new MoedaDAO();
  }

  @Override
  public Moeda inserir(Moeda obj) {
    return dao.inserir(obj);
  }

  @Override
  public List<Moeda> listar() {
    return dao.listar();
  }
  
}
