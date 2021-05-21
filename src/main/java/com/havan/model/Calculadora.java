package com.havan.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

  public static final BigDecimal TAXA_DE_CAMBIO = new BigDecimal("10.0");
  List<Moeda> moedas = new ArrayList<>();

  public Calculadora() {
    carregaMoedas();
  }

  void carregaMoedas() {
    Real r = new Real();
    moedas.add(r);
  }
}
