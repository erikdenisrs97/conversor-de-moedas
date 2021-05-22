package com.havan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.havan.model.Dolar;
import com.havan.model.Iene;
import com.havan.model.Real;

import org.junit.Test;

public class RealTest {
  
  @Test
  public void testaConvertePara() {
    // Real -> Iene e Dolar
    Dolar d = new Dolar();
    Real r = new Real();
    Iene i = new Iene();
    BigDecimal entrada = new BigDecimal("56.2");
    BigDecimal conversao = r.convertePara(d, entrada);
    BigDecimal esperado = new BigDecimal("10.68");
    assertEquals(esperado, conversao);
    entrada = new BigDecimal("56.2");
    conversao = r.convertePara(i, entrada);
    esperado = new BigDecimal("1160.53");
    assertEquals(esperado, conversao);
  }
}
