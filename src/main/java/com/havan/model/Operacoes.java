package com.havan.model;

/**
 * Operações
 *
 */

public class Operacoes {

  private Integer id;
  private String nomeCliente;
  private String moedaOrigem;
  private String moedaDestino;
  private String data;
  private String valorOriginal;
  
  public Operacoes(Integer id, String nomeCliente, String moedaOrigem, String moedaDestino, String data,
      String valorOriginal, String valorConvertido, String taxaCobrada) {
    this.id = id;
    this.nomeCliente = nomeCliente;
    this.moedaOrigem = moedaOrigem;
    this.moedaDestino = moedaDestino;
    this.data = data;
    this.valorOriginal = valorOriginal;
    this.valorConvertido = valorConvertido;
    this.taxaCobrada = taxaCobrada;
  }

  private String valorConvertido;
  private String taxaCobrada;
  

  public static void main(String[] args) {
    
  }

  public String getTaxaCobrada() {
    return taxaCobrada;
  }

  public void setTaxaCobrada(String taxaCobrada) {
    this.taxaCobrada = taxaCobrada;
  }

  public String getValorConvertido() {
    return valorConvertido;
  }

  public void setValorConvertido(String valorConvertido) {
    this.valorConvertido = valorConvertido;
  }

  public String getValorOriginal() {
    return valorOriginal;
  }

  public void setValorOriginal(String valorOriginal) {
    this.valorOriginal = valorOriginal;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
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