package com.havan.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculadora
 * A Calculadora é responsável por instanciar as moedas Real, Dolar e Iene.
 * Procurar a moeda dentro da lista e realizar a conversão descontando a taxa de 10%
 * A TAXA_DE_CAMBIO cobrada pela conversão pode ser configurada nesta Classe.
 */
public class Calculadora {

  public static final BigDecimal TAXA_DE_CAMBIO = new BigDecimal("0.10");
  static List<Moeda> moedas = new ArrayList<>();
  public static BigDecimal taxa;

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

  public BigDecimal converteMoeda(String moedaOrigem, String moedaDestino, BigDecimal valor) {
    try {
    Moeda moedaDeOrigem = procuraMoeda(moedaOrigem);
    Moeda moedaDeDestino = procuraMoeda(moedaDestino);
    BigDecimal valorConversao = valor;
    if(valorConversao.floatValue() < 0) {
      valorConversao = new BigDecimal("0");
    }
    BigDecimal valorConvertido = moedaDeOrigem.convertePara(moedaDeDestino, valorConversao);
    taxa = valorConvertido.multiply(TAXA_DE_CAMBIO);
    valorConvertido = valorConvertido.subtract(taxa);
    return valorConvertido.setScale(2, RoundingMode.HALF_EVEN);
    } catch (NullPointerException n) {
      System.err.println("Você tentou converter uma moeda que não existe ou duas iguais.");
    }
    return null;
  }

}
