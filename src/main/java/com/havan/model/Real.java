package com.havan.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Real extends Moeda {

/**
 * As taxas de conversão de Real para outras moedas podem ser configuradas aqui.
 */

  private static final BigDecimal TAXA_DOLAR = new BigDecimal("0.19");
  private static final BigDecimal TAXA_IENE = new BigDecimal("20.65");

  public Real() {
    this.setNomeMoeda("Real");
    this.setUnidadeMonetaria("R$");
  }

  @Override
  public BigDecimal convertePara(Moeda moeda, BigDecimal valor) {
    if(moeda.getNomeMoeda().contains("Dolar")) {
      return TAXA_DOLAR.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    } else if(moeda.getNomeMoeda().contains("Iene")) {
      return TAXA_IENE.multiply(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
    return null;
  }

}
