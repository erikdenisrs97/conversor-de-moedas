package com.havan.view;

import java.util.Scanner;

import com.havan.model.Calculadora;

/**
 * Conversor de Moedas
 *
 */
public class App {
  public static void main( String[] args ) {
    App a = new App();
    a.imprimeMenuPrincipal();
  }

  void imprimeMenuPrincipal() {
    System.out.println("O que você deseja fazer?");
    System.out.println("------------------------------");
    System.out.println("1 - Realizar Conversão");
    System.out.println("2 - Ver Todas as Operações");
    System.out.println("3 - Ver Valor Total das Operações");
    System.out.println("4 - Valor Total das Taxas Cobradas");
    System.out.println("------------------------------");
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    scan.close();
    switch (i) {
      case 1:
        realizaConversao();
        break;
      case 2:

        break;
      case 3:

        break;
      case 4:

        break;
    
      default:
        System.out.println("Você não inseriu uma opção valida.");
        break;
    }
  }

  void realizaConversao() {
    Scanner conversao = new Scanner(System.in);
    System.out.println("Qual é a moeda de origem?");
    String moedaOrigem = conversao.nextLine();
    System.out.println("Qual é a moeda de destino?");
    String moedaDestino = conversao.nextLine();
    System.out.println("Qual o valor que deseja converter?");
    String valor = conversao.nextLine();
    Calculadora c = new Calculadora();
    c.converteMoeda(moedaOrigem, moedaDestino, valor);
    // Armazena no banco
    conversao.close();
  }

}
