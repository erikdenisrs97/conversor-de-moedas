package com.havan.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

  public T inserir(T obj);
  public List<T> listar();
  public T procuraPorId(int id);

}
