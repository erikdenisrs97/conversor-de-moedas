package com.havan.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.havan.controller.OperacoesController;
import com.havan.model.Calculadora;
import com.havan.model.Operacoes;

/**
 * Conversor de Moedas
 *
 */
public class App {

  String nomeCliente;
  String moedaOrigem;
  String moedaDestino;
  BigDecimal valorOriginal;
  BigDecimal valorConvertido;
  BigDecimal taxaCobrada;
  Operacoes operacao;
  OperacoesController registrarOperacao = new OperacoesController();
  static Scanner leitura = new Scanner(System.in);
  static List<Operacoes> ops = new ArrayList<>();

  public static void main( String[] args ) {
    App a = new App();
    a.imprimeMenuPrincipal();
  }

  void imprimeMenuPrincipal() {
    System.out.println("Bem vindo à Casa de Câmbio Muito Dinheiro!!");
    System.out.println("O que você deseja fazer?");
    System.out.println("------------------------------");
    System.out.println("1 - Realizar Conversão");
    System.out.println("2 - Ver Todas as Operações ");
    System.out.println("3 - Ver Operações por Cliente");
    System.out.println("3 - Ver Operações por Intervalo de Datas");
    System.out.println("------------------------------");
    int i = leitura.nextInt();
    leitura.nextLine();
    switch (i) {
      case 1:
        realizaConversao();
        break;
      case 2:
        verOperacoes();
        break;
      case 3:
        OperacoesPorCliente();
        break;
      case 4:

        break;
    
      default:
        System.out.println("Você não inseriu uma opção valida.");
        break;
    }
  }

  void realizaConversao() {
    System.out.println("Qual é o nome do Cliente?");
    nomeCliente = leitura.nextLine();
    System.out.println("Qual é a moeda de origem?");
    moedaOrigem = leitura.nextLine();
    System.out.println("Qual é a moeda de destino?");
    moedaDestino = leitura.nextLine();
    System.out.println("Qual o valor que deseja converter?");
    valorOriginal = leitura.nextBigDecimal();
    Calculadora c = new Calculadora();
    taxaCobrada = c.TAXA_DE_CAMBIO;
    valorConvertido = c.converteMoeda(moedaOrigem, moedaDestino, valorOriginal);
    System.out.println("Você converteu " + moedaOrigem + " para " + moedaDestino);
    System.out.println("Valor da conversão: " + c.procuraMoeda(moedaDestino).getUnidadeMonetaria() + valorConvertido);
    operacao = new Operacoes(nomeCliente, moedaOrigem, moedaDestino, valorOriginal,
     valorConvertido, taxaCobrada);
    registrarOperacao.inserir(operacao);
    System.out.println("Operação salva no banco de dados.");
    leitura.close();
  }

  void verOperacoes() {
    List<Operacoes> ops = registrarOperacao.listar();
    System.out.println("######### LISTA DE OPERAÇÕES #########");
    System.out.println("CLIENTE - DATA DA OPERAÇÃO - MOEDA ORIGEM - MOEDA DESTINO - VALOR ORIGINAL - VALOR CONVERTIDO - TAXA");
    for(Operacoes operacao : ops) {
      System.out.println(operacao.getNomeCliente() + "         " + operacao.getDataOperacao() 
      + "         " + operacao.getMoedaOrigem() + "           " + operacao.getMoedaDestino() + "            " 
      + operacao.getValorOriginal() + "            " + operacao.getValorConvertido() + "        " + operacao.getTaxaCobrada() + "%");
    }
  }

  void OperacoesPorCliente() {
    List<Operacoes> ops = registrarOperacao.listarPorCliente("Havan");
    System.out.println("######### LISTA DE OPERAÇÕES #########");
    System.out.println("CLIENTE - DATA DA OPERAÇÃO - MOEDA ORIGEM - MOEDA DESTINO - VALOR ORIGINAL - VALOR CONVERTIDO - TAXA");
    for(Operacoes operacao : ops) {
      System.out.println(operacao.getNomeCliente() + "         " + operacao.getDataOperacao() 
      + "         " + operacao.getMoedaOrigem() + "           " + operacao.getMoedaDestino() + "            " 
      + operacao.getValorOriginal() + "            " + operacao.getValorConvertido() + "        " + operacao.getTaxaCobrada() + "%");
    }
  }

  void OperacoesPorData() {
    System.out.println("Digite a data de início: ");
    System.out.println("Digite a data de fim: ");
  }

}
