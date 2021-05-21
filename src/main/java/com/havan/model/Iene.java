package com.havan.model;

import java.math.BigDecimal;

public class Iene extends Moeda {
  
  private static final BigDecimal TAXA_REAL = new BigDecimal("0.048");
  private static final BigDecimal TAXA_DOLAR = new BigDecimal("0.0091");

  public Iene() {
    this.setNomeMoeda("Iene");
    this.setUnidadeMonetaria("Y");
  }

  @Override
  public BigDecimal convertePara(Moeda moeda, BigDecimal valor) {
    if(moeda.getNomeMoeda().contains("Dolar")) {
      return TAXA_DOLAR.multiply(valor);
    } else if(moeda.getNomeMoeda().contains("Real")) {
      return TAXA_REAL.multiply(valor);
    }
    return null;
  }
  
}
