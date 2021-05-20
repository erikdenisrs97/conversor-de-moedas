package com.havan.view;

import java.math.BigDecimal;

import com.havan.controller.OperacoesController;
import com.havan.model.Operacoes;

/**
 * Conversor de Moedas
 *
 */
public class App {
  public static void main( String[] args ) {
    BigDecimal valorOrigem = new BigDecimal("10.0");
    
    OperacoesController oc = new OperacoesController();
    Operacoes o = new Operacoes("Erik", "teste", "ew", "240597", valorOrigem, valorOrigem, valorOrigem);
    oc.inserir(o);
  }
}