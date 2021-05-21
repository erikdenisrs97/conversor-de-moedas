package com.havan.view;

import java.math.BigDecimal;

import com.havan.model.Calculadora;
import com.havan.model.Real;

/**
 * Conversor de Moedas
 *
 */
public class App {
  public static void main( String[] args ) {
    Calculadora c = new Calculadora();
    System.out.println(c.converteMoeda("Real", "Euro", "5.3"));
    System.out.println(c.converteMoeda("Dolar", "Real", "1"));
    System.out.println(c.converteMoeda("Dolar", "Iene", "1"));
  }
}
