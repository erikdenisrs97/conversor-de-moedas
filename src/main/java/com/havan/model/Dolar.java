package com.havan.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * As taxas de conversão de Dolar para outras moedas podem ser configuradas aqui.
 */
public class Dolar extends Moeda {
  
  private static final BigDecimal TAXA_REAL = new BigDecimal("5.3");
  private static final BigDecimal TAXA_IENE = new BigDecimal("109.62");

  public Dolar() {
    this.setNomeMoeda("Dolar");
    this.setUnidadeMonetaria("U$");
  }

  @Override
  public BigDecimal convertePara(Moeda moeda, BigDecimal valor) {
    if(moeda.getNomeMoeda().contains("Iene")) {
      return TAXA_IENE.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    } else if(moeda.getNomeMoeda().contains("Real")) {
      return TAXA_REAL.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
    return null;
  }

}
