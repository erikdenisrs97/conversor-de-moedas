package com.havan.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

  public void inserir(T obj);
  public List<T> listar();

}
