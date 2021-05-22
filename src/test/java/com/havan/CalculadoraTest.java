package com.havan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.havan.model.Calculadora;
import com.havan.model.Moeda;

import org.junit.Test;

public class CalculadoraTest {
  
  @Test
  public void testaProcuraMoeda() {
    Calculadora c = new Calculadora();
    Moeda r = c.procuraMoeda("Real");
    Moeda d = c.procuraMoeda("Dolar");
    Moeda i = c.procuraMoeda("Iene");
    assertEquals(r, r);
    assertEquals(d, d);
    assertEquals(i, i);
  }

  @Test
  public void testaConverteMoeda() {
    Calculadora c = new Calculadora();
    // Real -> Dolar
    BigDecimal entrada = new BigDecimal("13.0");
    BigDecimal atual = c.converteMoeda("Real", "Dolar", entrada);
    BigDecimal esperado = new BigDecimal("2.22").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("54332.56");
    atual = c.converteMoeda("Real", "Dolar", entrada);
    esperado = new BigDecimal("9290.87").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-65");
    atual = c.converteMoeda("Real", "Dolar", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);

    // Real - Iene
    entrada = new BigDecimal("56");
    atual = c.converteMoeda("Real", "Iene", entrada);
    esperado = new BigDecimal("1040.76").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("4231452.77");
    atual = c.converteMoeda("Real", "Iene", entrada);
    esperado = new BigDecimal("78641549.73").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-32");
    atual = c.converteMoeda("Real", "Iene", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);

    // Dolar -> Real
    entrada = new BigDecimal("56");
    atual = c.converteMoeda("Dolar", "Real", entrada);
    esperado = new BigDecimal("267.12").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("4231452.77");
    atual = c.converteMoeda("Dolar", "Real", entrada);
    esperado = new BigDecimal("20184029.71").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-32");
    atual = c.converteMoeda("Dolar", "Real", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);

    // Dolar -> Iene
    entrada = new BigDecimal("56");
    atual = c.converteMoeda("Dolar", "Iene", entrada);
    esperado = new BigDecimal("5524.85").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("4231452.77");
    atual = c.converteMoeda("Dolar", "Iene", entrada);
    esperado = new BigDecimal("417466667.38").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-32");
    atual = c.converteMoeda("Dolar", "Iene", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);

    // Iene -> Dolar
    entrada = new BigDecimal("56");
    atual = c.converteMoeda("Iene", "Dolar", entrada);
    esperado = new BigDecimal("0.46").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("4231452.77");
    atual = c.converteMoeda("Iene", "Dolar", entrada);
    esperado = new BigDecimal("34655.60").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-32");
    atual = c.converteMoeda("Iene", "Dolar", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);

    // Iene -> Real
    entrada = new BigDecimal("56");
    atual = c.converteMoeda("Iene", "Real", entrada);
    esperado = new BigDecimal("2.42").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("4231452.77");
    atual = c.converteMoeda("Iene", "Real", entrada);
    esperado = new BigDecimal("182798.76").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
    entrada = new BigDecimal("-32");
    atual = c.converteMoeda("Iene", "Real", entrada);
    esperado = new BigDecimal("0").setScale(2, RoundingMode.HALF_EVEN);
    assertEquals(esperado, atual);
  }

}
