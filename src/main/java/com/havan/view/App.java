package com.havan.view;

import java.math.BigDecimal;

import com.havan.model.Real;

/**
 * Conversor de Moedas
 *
 */
public class App {
  public static void main( String[] args ) {
    Real r = new Real();
    BigDecimal valor = new BigDecimal("10.0");
    System.out.println(r.converteParaDolar(valor));
    System.out.println(r.getUnidadeMonetaria());
    System.out.println(r.getNomeMoeda());
  }
}
