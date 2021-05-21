package com.havan.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

  public static final BigDecimal TAXA_DE_CAMBIO = new BigDecimal("10.0");
  static List<Moeda> moedas = new ArrayList<>();

  public Calculadora() {
    carregaMoedas();
  }

  private void carregaMoedas() {
    Real r = new Real();
    Dolar d = new Dolar();
    Iene i = new Iene();
    moedas.add(r);
    moedas.add(d);
    moedas.add(i);
  }

  public Moeda procuraMoeda(String nomeDaMoeda) {
    for(Moeda moeda : moedas) {
      if(moeda.getNomeMoeda().contains(nomeDaMoeda)) {
        return moeda;
      }
    }
    return null;
  }

  public BigDecimal converteMoeda(String moedaOrigem, String moedaDestino, String valor) {
    try {
    Moeda moedaDeOrigem = procuraMoeda(moedaOrigem);
    Moeda moedaDeDestino = procuraMoeda(moedaDestino);
    BigDecimal valorConversao = new BigDecimal(valor);
    BigDecimal valorConvertido = moedaDeOrigem.convertePara(moedaDeDestino, valorConversao);
    return valorConvertido;
    } catch (NullPointerException n) {
      System.err.println("Você tentou converter uma moeda que não existe.");
    }
    return null;
  }

}
