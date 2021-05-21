package com.havan.controller;

import java.util.List;

public interface InterfaceController<T> {
  
  public T inserir(T obj);
  public List<T> listar();
  public T procuraPorId(int id);

}
