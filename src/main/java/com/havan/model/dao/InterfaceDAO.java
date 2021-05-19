package com.havan.model.dao;

public interface InterfaceDAO<T> {

  public void inserir(T obj);
  public void editar(T obj);
  public void deletar(int id);
  public T buscarPorID(int id);
  public List<T> listar();

}
