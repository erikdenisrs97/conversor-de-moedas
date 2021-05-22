package com.havan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.havan.model.Dolar;
import com.havan.model.Iene;
import com.havan.model.Real;

import org.junit.Test;

public class DolarTest {
  
  @Test
  public void testaConvertePara() {
    // Dolar -> Iene e Real
    Dolar d = new Dolar();
    Real r = new Real();
    Iene i = new Iene();
    BigDecimal entrada = new BigDecimal("56.2");
    BigDecimal conversao = d.convertePara(r, entrada);
    BigDecimal esperado = new BigDecimal("297.86");
    assertEquals(esperado, conversao);
    entrada = new BigDecimal("56.2");
    conversao = d.convertePara(i, entrada);
    esperado = new BigDecimal("6160.64");
    assertEquals(esperado, conversao);
  }
}
