package com.havan.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Operações
 *
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

  public BigDecimal getTaxaCobrada() {
    return taxaCobrada;
  }

  public void setTaxaCobrada(BigDecimal taxaCobrada) {
    this.taxaCobrada = taxaCobrada;
  }

  public BigDecimal getValorConvertido() {
    return valorConvertido;
  }

  public void setValorConvertido(BigDecimal valorConvertido) {
    this.valorConvertido = valorConvertido;
  }

  public BigDecimal getValorOriginal() {
    return valorOriginal;
  }

  public void setValorOriginal(BigDecimal valorOriginal) {
    this.valorOriginal = valorOriginal;
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