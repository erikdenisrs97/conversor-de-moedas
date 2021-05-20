package com.havan.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {

  private static final String PATH = "./env.properties";

  public static String get(String chave) {
    Properties properties = new Properties();
    FileInputStream file;
    try {
      file = new FileInputStream(PATH);
      properties.load(file);
      file.close();
    } catch (FileNotFoundException e) {
      System.err.println("O arquivo de propriedades não foi encontrado.");
    } catch (IOException e) {
      System.err.println("Ocorreu um problema ao ler o arquivo.");
    }
    if(!properties.containsKey(chave)) {
      throw new RuntimeException("Chave " + chave + " não encontrada no arquivo " 
        + PATH + ".");
    }
    return properties.getProperty(chave);
  }
}
