package com.havan.model;

import java.math.BigDecimal;

public class Real extends Moeda {

  private static final BigDecimal TAXA_DOLAR = new BigDecimal("10.0");
  private static final BigDecimal TAXA_IENE = new BigDecimal("10.0");

  public Real() {
    this.setNomeMoeda("Real");
    this.setUnidadeMonetaria("RS");
  }

  public BigDecimal converteParaDolar(BigDecimal valor) {
    return valor.multiply(TAXA_DOLAR);
  }

  public BigDecimal converteParaIene(BigDecimal valor) {
    return valor.multiply(TAXA_IENE);
  }
  
}
