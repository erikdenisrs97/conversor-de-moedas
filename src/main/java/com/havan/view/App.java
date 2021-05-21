package com.havan.view;

import java.math.BigDecimal;

import com.havan.controller.MoedaController;
import com.havan.controller.OperacoesController;
import com.havan.model.Moeda;
import com.havan.model.Operacoes;

/**
 * Conversor de Moedas
 *
 */
public class App {
  public static void main( String[] args ) {
    /* BigDecimal valorOrigem = new BigDecimal("10.0");
    
    OperacoesController oc = new OperacoesController();
    Operacoes o = new Operacoes("Camila", "teste", "ew", valorOrigem, valorOrigem, valorOrigem);
    oc.inserir(o); */

    MoedaController mc = new MoedaController();
    System.out.println(mc.procuraPorId(1).getNomeMoeda());

  }
}