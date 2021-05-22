package com.havan.model;

import java.math.BigDecimal;

public abstract class Moeda {
  
  private String nomeMoeda;
  private String unidadeMonetaria;
  private String valor;

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getUnidadeMonetaria() {
    return unidadeMonetaria;
  }

  public void setUnidadeMonetaria(String unidadeMonetaria) {
    this.unidadeMonetaria = unidadeMonetaria;
  }

  public String getNomeMoeda() {
    return nomeMoeda;
  }

  public void setNomeMoeda(String nomeMoeda) {
    this.nomeMoeda = nomeMoeda;
  }

  public abstract BigDecimal convertePara(Moeda moeda, BigDecimal valor);

}
