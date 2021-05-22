package com.havan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.havan.model.Dolar;
import com.havan.model.Iene;
import com.havan.model.Real;

import org.junit.Test;

public class IeneTest {
  
  @Test
  public void testaConvertePara() {
  // Iene -> Dolar e Real
  Dolar d = new Dolar();
  Real r = new Real();
  Iene i = new Iene();
  BigDecimal entrada = new BigDecimal("56.2");
  BigDecimal conversao = i.convertePara(r, entrada);
  BigDecimal esperado = new BigDecimal("2.70");
  assertEquals(esperado, conversao);
  entrada = new BigDecimal("56.2");
  conversao = i.convertePara(d, entrada);
  esperado = new BigDecimal("0.51");
  assertEquals(esperado, conversao);
  }

}
