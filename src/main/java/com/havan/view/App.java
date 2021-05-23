package com.havan.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.havan.controller.OperacoesController;
import com.havan.model.Calculadora;
import com.havan.model.Operacoes;

/**
 * Conversor de Moedas
 * Esse código é a 2ª parte do desafio ProWay/Havan Tech Labs 2021.
 * Esse código é um conversor de moedas entre Iene, Real e Dolar.
 * Todas as conversões são salvas dentro do banco de dados e 
 * é possível extrair relatórios seguindo as intruções do menu principal.
 * 
 * @author Erik Rodrigues
 * @since 1.0
 */
public class App {

  String nomeCliente;
  String moedaOrigem;
  String moedaDestino;
  BigDecimal valorOriginal;
  BigDecimal valorConvertido;
  BigDecimal taxaCobrada;
  Operacoes operacao;
  OperacoesController operacaoController = new OperacoesController();
  static Scanner leitura = new Scanner(System.in);
  static List<Operacoes> ops = new ArrayList<>();
  public static final DecimalFormat FORMATADOR = new DecimalFormat("#,##0.00");

  public App() {
    Locale.setDefault(new Locale("pt", "BR")); // Mudança do Locale;
    imprimeMenuPrincipal();
  }

  public static void main( String[] args ) {
    App a = new App();
  }

  void imprimeMenuPrincipal() {
    System.out.println("Bem vindo à Casa de Câmbio Muito Dinheiro!!");
    System.out.println("O que você deseja fazer?");
    System.out.println("------------------------------");
    System.out.println("1 - Realizar Conversão"); // Ok
    System.out.println("2 - Ver Todas as Operações "); // Ok
    System.out.println("3 - Ver Operações por Cliente"); // Ok
    System.out.println("4 - Ver Operações por Intervalo de Datas"); // Ok
    System.out.println("5 - Valor Total das Operações"); // Ok
    System.out.println("6 - Valor Total por Cliente"); // Ok
    System.out.println("7 - Valor Total por Intervalo de Datas"); // Ok
    System.out.println("8 - Ver Total das Taxas"); // OK;
    System.out.println("9 - Taxa Total por Cliente"); // OK;
    System.out.println("10 - Taxa Total por Intervalo de Datas"); // OK
    System.out.println("------------------------------");
    int i = leitura.nextInt();
    leitura.nextLine();
    switch (i) {
      case 1:
        realizaConversao();
        break;
      case 2:
        verTodasOperacoes();
        break;
      case 3:
        OperacoesPorCliente();
        break;
      case 4:
        OperacoesPorData();
        break;
      case 5:
        valoresTotais();
        break;
      case 6:
        valoresTotaisPorCliente();
        break;
      case 7:
        valoresTotaisPorData();
        break;
      case 8:
        taxasTotais();
        break;
      case 9:
        taxasTotaisPorCliente();
        break;
      case 10:
        taxasTotaisPorData();
        break;
      default:
        System.out.println("Você não inseriu uma opção valida.");
        break;
    }
  }

  // Realiza conversão entre moedas.
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
    valorConvertido = c.converteMoeda(moedaOrigem, moedaDestino, valorOriginal);
    taxaCobrada = Calculadora.taxa;
    operacao = new Operacoes(nomeCliente, moedaOrigem, moedaDestino, valorOriginal,
     valorConvertido, taxaCobrada);
    operacaoController.inserir(operacao);
    String valorFormatado = operacao.getValorConvertidoFormatado();
    System.out.println("Você converteu " + moedaOrigem + " para " + moedaDestino);
    System.out.println("Valor da conversão: " + c.procuraMoeda(moedaDestino).getUnidadeMonetaria() + valorFormatado);
    leitura.close();
  }

  void verTodasOperacoes() {
    List<Operacoes> ops = operacaoController.listar();
    System.out.println("######### LISTA DE OPERAÇÕES #########");
    imprimeLista(ops);
  }

  void OperacoesPorCliente() {
    System.out.println("Digite o nome do cliente que deseja pesquisar: ");
    Scanner leitura = new Scanner(System.in);
    String cliente = leitura.nextLine();
    List<Operacoes> ops = operacaoController.listarPorCliente(cliente);
    System.out.println("######### LISTA DE OPERAÇÕES POR CLIENTE #########");
    imprimeLista(ops);
    leitura.close();
  }

  void OperacoesPorData() {
    System.out.println("######### LISTA DE OPERAÇÕES POR DATA #########");
    System.out.println("Digite a data no formato: 24/05/1997");
    System.out.println("Digite a data de início: ");
    Scanner leitura = new Scanner(System.in);
    String dataInicio = leitura.nextLine();
    System.out.println("Digite a data de fim: ");
    String dataFim = leitura.nextLine();
    leitura.close();
    List<Operacoes> ops = operacaoController.listarPorData(dataInicio, dataFim);
    imprimeLista(ops);
  }

  void valoresTotais() {
    String dolar = FORMATADOR.format(operacaoController.valorTotal("Dolar"));
    String real = FORMATADOR.format(operacaoController.valorTotal("Real"));
    String iene = FORMATADOR.format(operacaoController.valorTotal("Iene"));
    System.out.println("Total de dólares convertidos para outras moedas: " +
      dolar);
    System.out.println("Total de reais convertidos para outras moedas: " + 
      real);
    System.out.println("Total de reais convertidos para outras moedas: " + 
      iene);
  }

  void valoresTotaisPorData() {
    System.out.println("Digite a data no formato: 24/05/1997");
    System.out.println("Digite a data de início: ");
    Scanner leitura = new Scanner(System.in);
    String dataInicio = leitura.nextLine();
    System.out.println("Digite a data de fim: ");
    String dataFim = leitura.nextLine();
    leitura.close();
    System.out.println("Dentro do intervalo escolhido os valores totais foram:");
    System.out.println("Total de dólares convertidos para outras moedas: " +
      operacaoController.valorTotalPorData("Dolar", dataInicio, dataFim));
    System.out.println("Total de reais convertidos para outras moedas: " + 
      operacaoController.valorTotalPorData("Real", dataInicio, dataFim));
    System.out.println("Total de ienes convertidos para outras moedas: " + 
      operacaoController.valorTotalPorData("Iene", dataInicio, dataFim));
  }

  void valoresTotaisPorCliente() {
    System.out.println("Digite o nome do cliente: ");
    Scanner leitura = new Scanner(System.in);
    nomeCliente = leitura.nextLine();
    System.out.println("Moedas convertidas pelo cliente " + nomeCliente + ":");
    List<Operacoes> ops = operacaoController.valorTotalPorCliente(nomeCliente);
    leitura.close();
    for(Operacoes operacao : ops) {
      System.out.println(operacao.getMoedaOrigem() + ": " + operacao.getValorOriginalFormatado());
    }
  }

  void taxasTotais() {
    System.out.println("Taxas totais cobradas de conversões para Dolar: " +
    operacaoController.taxaTotal("Dolar"));
    System.out.println("Taxas totais cobradas de conversões para Real: " + 
    operacaoController.taxaTotal("Real"));
    System.out.println("Taxas totais cobradas de conversões para Iene: " + 
    operacaoController.taxaTotal("Iene"));
  }

  void taxasTotaisPorCliente() {
    System.out.println("Digite o nome do cliente: ");
    Scanner leitura = new Scanner(System.in);
    nomeCliente = leitura.nextLine();
    System.out.println("Taxas pagas pelo cliente: " + nomeCliente);
    List<Operacoes> ops = operacaoController.taxaTotalPorCliente(nomeCliente);
    leitura.close();
    for(Operacoes operacao : ops) {
      System.out.println(operacao.getMoedaOrigem() + ": " + operacao.getValorOriginalFormatado());
    }
  }

  void taxasTotaisPorData() {
    System.out.println("Digite a data no formato: 24/05/1997");
    System.out.println("Digite a data de início: ");
    Scanner leitura = new Scanner(System.in);
    String dataInicio = leitura.nextLine();
    System.out.println("Digite a data de fim: ");
    String dataFim = leitura.nextLine();
    leitura.close();
    System.out.println("Dentro do intervalo escolhido as taxas totais foram:");
    System.out.println("Taxas totais cobradas de conversões para Dolar: " +
      operacaoController.taxaTotalPorData("Dolar", dataInicio, dataFim));
    System.out.println("Taxas totais cobradas de conversões para Real: " + 
      operacaoController.taxaTotalPorData("Real", dataInicio, dataFim));
    System.out.println("Taxas totais cobradas de conversões para Iene: " + 
      operacaoController.taxaTotalPorData("Iene", dataInicio, dataFim));
  }

  void imprimeLista(List<Operacoes> ops) {
    System.out.println("CLIENTE - DATA DA OPERAÇÃO - MOEDA ORIGEM - MOEDA DESTINO - VALOR ORIGINAL - VALOR CONVERTIDO - TAXA");
    for(Operacoes operacao : ops) {
      System.out.println(operacao.getNomeCliente() + "         " + operacao.getDataOperacao() 
      + "         " + operacao.getMoedaOrigem() + "           " + operacao.getMoedaDestino() + "            " 
      + operacao.getValorOriginalFormatado() + "            " + operacao.getValorConvertidoFormatado() + "        " + operacao.getTaxaCobradaFormatada());
    }
  }

}
