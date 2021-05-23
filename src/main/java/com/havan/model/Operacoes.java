package com.havan.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * Operações
 * A classe operações é o model para salvar as operações no banco de dados.
 */

public class Operacoes {

  private Integer id;
  private String nomeCliente;
  private String moedaOrigem;
  private String moedaDestino;
  private LocalDate dataOperacao;
  private BigDecimal valorOriginal;
  private BigDecimal valorConvertido;
  private BigDecimal taxaCobrada;
  private static final DecimalFormat FORMATADOR = new DecimalFormat("#,##0.00");
  
  // Construtor para criar uma operação.
  public Operacoes(String nomeCliente, String moedaOrigem, String moedaDestino,
      BigDecimal valorOriginal, BigDecimal valorConvertido, BigDecimal taxaCobrada) {
    this.nomeCliente = nomeCliente;
    this.moedaOrigem = moedaOrigem;
    this.moedaDestino = moedaDestino;
    this.dataOperacao = LocalDate.now();
    this.valorOriginal = valorOriginal;
    this.valorConvertido = valorConvertido;
    this.taxaCobrada = taxaCobrada;
  }

  // Construtor para imprimir uma operação.
  public Operacoes(Integer id, String nomeCliente, String moedaOrigem, String moedaDestino, LocalDate dataOperacao,
    BigDecimal valorOriginal, BigDecimal valorConvertido, BigDecimal taxaCobrada) {
    this.id = id;
    this.nomeCliente = nomeCliente;
    this.moedaOrigem = moedaOrigem;
    this.moedaDestino = moedaDestino;
    this.dataOperacao = dataOperacao;
    this.valorOriginal = valorOriginal;
    this.valorConvertido = valorConvertido;
    this.taxaCobrada = taxaCobrada;
  }

  // Construtor para imprimir valor Total Por Cliente.
  public Operacoes(String nomeCliente, String moedaOrigem, BigDecimal valorOriginal) {
    this.nomeCliente = nomeCliente;
    this.moedaOrigem = moedaOrigem;
    this.valorOriginal = valorOriginal;
  }

  public BigDecimal getTaxaCobrada() {
    return taxaCobrada;
  }

  public void setTaxaCobrada(BigDecimal taxaCobrada) {
    this.taxaCobrada = taxaCobrada;
  }

  public BigDecimal getValorConvertido() {
    return valorConvertido;
  }

  public String getValorConvertidoFormatado() {
    return FORMATADOR.format(valorConvertido);
  }

  public String getValorOriginalFormatado() {
    return FORMATADOR.format(valorOriginal);
  }

  public String getTaxaCobradaFormatada() {
    return FORMATADOR.format(taxaCobrada);
  }

  public void setValorConvertido(BigDecimal valorConvertido) {
    this.valorConvertido = valorConvertido.setScale(2, RoundingMode.HALF_EVEN);
  }

  public BigDecimal getValorOriginal() {
    return valorOriginal;
  }

  public void setValorOriginal(BigDecimal valorOriginal) {
    this.valorOriginal = valorOriginal.setScale(2, RoundingMode.HALF_EVEN);
  }

  public LocalDate getDataOperacao() {
    return dataOperacao;
  }

  public String getMoedaDestino() {
    return moedaDestino;
  }

  public void setMoedaDestino(String moedaDestino) {
    this.moedaDestino = moedaDestino;
  }

  public String getMoedaOrigem() {
    return moedaOrigem;
  }

  public void setMoedaOrigem(String moedaOrigem) {
    this.moedaOrigem = moedaOrigem;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}