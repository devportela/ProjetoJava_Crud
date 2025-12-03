CREATE DATABASE ProjetoCrudClient;
USE ProjetoCrudClient;

CREATE TABLE Cliente(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(150) NOT NULL,
    cpf varchar(11) UNIQUE NOT NULL,
    email varchar(150),
    rua varchar(150),
    receberNT boolean,
    cidade varchar(150),
    telefone varchar (15)
);

CREATE TABLE Produto (
    id_prod int AUTO_INCREMENT PRIMARY KEY,
    nome_prod varchar(50) UNIQUE NOT NULL,
    descricao varchar(250),
    quantidade int,
    precoUnitario decimal(10,2),
    fornecedor varchar(100)
);

CREATE TABLE Admin (
    id_admin INT PRIMARY KEY,
    senha VARCHAR(50) NOT NULL
);

INSERT INTO Admin (id_admin, senha)
VALUES (1, '1234');


