package com.havan.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * As taxas de conversão de Iene para outras moedas podem ser configuradas aqui.
 */
public class Iene extends Moeda {
  
  private static final BigDecimal TAXA_REAL = new BigDecimal("0.048");
  private static final BigDecimal TAXA_DOLAR = new BigDecimal("0.0091");

  public Iene() {
    this.setNomeMoeda("Iene");
    this.setUnidadeMonetaria("¥");
  }

  @Override
  public BigDecimal convertePara(Moeda moeda, BigDecimal valor) {
    if(moeda.getNomeMoeda().contains("Dolar")) {
      return TAXA_DOLAR.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    } else if(moeda.getNomeMoeda().contains("Real")) {
      return TAXA_REAL.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
    return null;
  }
  
}
