package com.havan.model;

import java.text.DecimalFormat;

public abstract class Moeda {
  
  private Integer id;
  private String nomeMoeda;
  private String unidadeMonetaria;
  private String valor;
  private static final DecimalFormat FORMATADOR = new DecimalFormat("#,##0.00");
  
  public Moeda(String nomeMoeda, String unidadeMonetaria, String valor) {
    this.nomeMoeda = nomeMoeda;
    this.unidadeMonetaria = unidadeMonetaria;
    this.valor = valor;
  }

  public Integer getId() {
    return id;
  }

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

  public void setId(Integer id) {
    this.id = id;
  }

}
