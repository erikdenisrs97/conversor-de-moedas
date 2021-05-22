# CONVERSOR DE MOEDAS EM JAVA

------

## Sobre o Programa:

------

Esse programa faz parte da 2ª parte do teste solicitado pelo programa ProWay/Havan Tech Labs 2021.

Trata-se de um conversor básico entre moedas (Iene, Real e Dolar) com capacidade de armazenamento em banco de dados e extração de relatórios.

Requisitos Implementados:

- [x] Operações de conversão salvas no banco

- [x] Lista de operações

- [x] Valor total das operações

- [x] Valor total das taxas cobradas

- [x] Relatórios filtrados por intervalo de tempo e cliente

- [ ] Cadastro de Valores de Conversão

  

## Os Usuários Podem:

------



- Efetuar a conversão de moedas entre (Iene, Real e Dolar)
- Visualizar todas as operações de conversão efetuadas
- Visualizar o valor total das operações de conversão
- Visualizar o total das taxas cobradas nas operações
- As operações, taxas e valores totais poderão ser visualizados também por cliente ou intervalo de data

## Tecnologias Utilizadas:

------



- Java [JDK 8+]
- JDBC
- Apache Maven
- PostgreSQL
- Arch Linux como Sistema Operacional

## Tecnologias Necessárias:

------



- Java [JDK 8+]

- PostgreSQL

  <u>Nota: As instruções de inicialização do banco serão baseadas em CLI do Linux</u>

- Apache Maven

- Visual Studio Code (ou outra IDE de preferência)

  <u>Nota: As instruções de inicialização serão baseadas no Visual Studio Code</u> 

  

# Como Inicializar a Aplicação 

------

## Configurando o Banco de Dados

------

1. Efetue o login com seu usuário admistrador: <code> psql postgres <usuario> </code> (digite a senha se necessário)

2. Copie e cole o script SQL abaixo:

   ```sql
   CREATE DATABASE havantechlabs WITH ENCODING 'UTF8' LC_COLLATE='en_US.UTF-8' LC_CTYPE='en_US.UTF-8';
   
   \c havantechlabs;
   
   CREATE TABLE operacoes (
     id SERIAL PRIMARY KEY,
     nome_cliente VARCHAR NOT NULL,
     moeda_origem VARCHAR NOT NULL,
     moeda_destino VARCHAR NOT NULL,
     data_operacao DATE NOT NULL,
     valor_original DECIMAL NOT NULL,
     valor_convertido DECIMAL NOT NULL,
     taxa_cobrada DECIMAL NOT NULL,
   );
   ```

Se você encontrar dificuldades, poderá dar uma olhada em: <code> https://www.postgresql.org/docs/ </code>

## Clonando o Repositório

------

- O repositório poderá ser clonado via linha de comando:

  <pre>git clone https://github.com/erikdenao/havan-tech-labs02.git</pre>

- Você também poderá clonar através do site do Github: <code> https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github </code>

## Configurando o env.properties

------

O arquivo env.properties na pasta raiz do projeto contém os dados de acesso ao banco de dados.

Você precisa editar de acordo com seu usuário do banco e senha de acesso.

```properties
# Database
bd.url = jdbc:postgresql://localhost:5432/havantechlabs
bd.driver = org.postgresql.Driver
bd.usuario = <usuario>
bd.senha = <senha>
```



## Compilando a Aplicação

------

1. Na IDE, basta selecionar o arquivo App.java localizado na pasta view e compilar através do botão Run e então as opções poderão ser vistas no terminal:

   ![image-20210522151101619](/home/erikdenis/.config/Typora/typora-user-images/image-20210522151101619.png)

   ![image-20210522151212748](/home/erikdenis/.config/Typora/typora-user-images/image-20210522151212748.png)

   

2.  Também é possível compilar através do Maven: <code> https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html </code>

   



