# 🚀 Projeto Java CRUD

Aplicação Java desktop desenvolvida com **Java Swing**, focada na implementação completa de um sistema **CRUD (Create, Read, Update e Delete)**. O projeto foi estruturado de forma profissional, com separação clara de responsabilidades, interface gráfica personalizada e integração com banco de dados MySQL.

---

## ✨ Visão Geral

O sistema permite o gerenciamento de **clientes e produtos**, contando com telas de login, cadastro, listagem, edição, exclusão e relatórios. A aplicação utiliza **Java Swing com MigLayout**, JDBC para persistência de dados e componentes customizados para melhorar a experiência do usuário.

Este projeto foi desenvolvido com foco em **organização, clareza de código e boas práticas**, sendo ideal para portfólio e projetos acadêmicos.

---

## 🧩 Funcionalidades

* 🔐 Tela de login e registro
* 👤 Cadastro, edição, listagem e exclusão de clientes
* 📦 Cadastro, edição, listagem e exclusão de produtos
* 📊 Relatórios de clientes e produtos
* 🖥️ Interface gráfica desktop com Java Swing
* 🔗 Integração com banco de dados MySQL

---

## 🛠️ Tecnologias Utilizadas

* ☕ Java
* 🖼️ Java Swing
* 🔌 JDBC
* 🗄️ MySQL
* 📐 MigLayout

---

## 📦 Dependências Necessárias

Para executar corretamente o projeto, é necessário adicionar as seguintes bibliotecas ao classpath:

* MySQL Connector/J
* miglayout-core
* miglayout-swing

---

## 📁 Estrutura do Projeto

```
Project
├── components
│   ├── MainForm
│   ├── PainelLoginAndRegister
│   ├── PanelCover
│   └── PanelLoginAndRegisterForm
│
├── dao
│   ├── AdminDAO
│   ├── ClienteDAO
│   ├── ProdutoDAO
│   └── Conexao
│
├── gui
│   ├── PainelClienteGUI
│   └── PainelProdutoGUI
│
├── imgs
│
├── model
│   ├── Cliente
│   └── Produto
│
├── swing
│   ├── Button
│   ├── ButtonOutline
│   ├── MyPasswordField
│   └── MyTextField
│
└── view
    ├── JanelaPrincipal
    ├── RelatorioCliente
    └── RelatorioProduto
```

---

## ▶️ Como Executar

1. Clone o repositório

```bash
git clone https://github.com/devportela/ProjetoJava_Crud.git
```

2. Importe o projeto em sua IDE
3. Adicione as dependências (MySQL Connector e MigLayout)
4. Configure o banco de dados utilizando o arquivo `banco.sql`
5. Ajuste as credenciais de conexão na classe `Conexao`
6. Execute a classe principal da aplicação

---

## 🎯 Objetivo do Projeto

Demonstrar domínio em **Java, Programação Orientada a Objetos, Java Swing, JDBC e organização em camadas**, por meio do desenvolvimento de um sistema CRUD completo, funcional e bem estruturado.

---

## 👥 Projeto em Equipe

Este projeto foi desenvolvido em **equipe**, promovendo colaboração, divisão de responsabilidades e integração de ideias durante todo o processo de desenvolvimento.

O trabalho envolveu planejamento, implementação das funcionalidades, organização da estrutura do projeto e integração com banco de dados, seguindo boas práticas de desenvolvimento de software.

---

## 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como **atividade acadêmica**, com o objetivo de ser **apresentado para avaliação de um professor**. Ele contempla requisitos técnicos como uso de Java Swing, JDBC, banco de dados relacional, organização em camadas e funcionamento completo de um sistema CRUD.

---

## 👨‍💻 Contribuidores

* Gustavo Portela de Lima
* Bruno Dos Santos Romão
* Maria Eduarda Jardim Sousa
* Laryssa Caetano 
* Arthur Bispo Dos Santos

---

📌 Projeto desenvolvido com fins educacionais e para composição de portfólio, evidenciando boas práticas no desenvolvimento de aplicações Java desktop.
