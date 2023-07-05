# Área Administrativa - CRUD
Este é um CRUD simples e estruturado para uma Área Administrativa, implementado utilizando conceitos de programação orientada a objetos (POO) e outros padrões de projeto. Ele inclui classes abstratas, classes não abstratas, interfaces, encapsulamento, construtores, herança, polimorfismo, utilização de SQL, além de outras boas práticas de programação.

# Estrutura do Projeto
O projeto está organizado em diferentes pacotes e classes para facilitar a manutenção e escalabilidade. A seguir, descreveremos cada um desses componentes:

## Controller
O pacote Controller contém classes responsáveis pela lógica de controle e interação com as outras camadas do projeto. Essas classes recebem as requisições do usuário e invocam os métodos apropriados nas camadas inferiores.

## DAO
O pacote DAO contém as classes de acesso a dados. Elas são responsáveis por realizar operações de leitura, escrita, atualização e exclusão no banco de dados. Nesse projeto, utilizamos o PostgreSQL como banco de dados, e as classes DAO fornecem métodos para interagir com as tabelas e registros.

## Exception
O pacote Exception contém as classes de exceção personalizadas para lidar com erros específicos do sistema. Cada tipo de erro possui sua própria classe de exceção, permitindo um tratamento de erros mais granular e preciso.

## Factory
O pacote Factory contém classe responsável pela conexão com o banco de dados.

## Model
O pacote Model contém as classes de modelo que representam as entidades do sistema. Essas classes possuem atributos, métodos e relacionamentos que refletem a estrutura do banco de dados.

## Service
O pacote Service contém as classes de serviço que implementam a lógica de negócio do sistema. Essas classes são responsáveis por realizar validações, processamentos e chamadas aos objetos DAO para realizar as operações de banco de dados.

## Shared
O pacote Shared contém classes e interfaces que podem ser compartilhadas por diferentes componentes do sistema. Essas classes e interfaces definem funcionalidades genéricas, utilitárias ou comuns a várias partes do sistema.

## Configuração do Banco de Dados
O projeto utiliza o banco de dados PostgreSQL. Abaixo estão as instruções SQL para criar o banco de dados e as tabelas necessárias:

CREATE DATABASE banco_administrativo;

CREATE TABLE public.usuarios (
	id serial4 NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	CONSTRAINT usuarios_pkey PRIMARY KEY (id)
);

CREATE TABLE public.usuarios_permissoes (
	id serial4 NOT NULL,
	id_usuario int4 NOT NULL,
	permissao int4 NULL,
	CONSTRAINT id_pkey PRIMARY KEY (id),
	CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id)
);

Lembrando que é necessário ter o PostgreSQL instalado e configurado corretamente.

## Para executar o projeto, siga as etapas abaixo:

Clone o repositório para a sua máquina local.</br>
Certifique-se de ter o PostgreSQL instalado e configurado corretamente.</br>
Crie um banco de dados chamado "banco_administrativo".</br>
Execute as instruções SQL fornecidas acima para criar as tabelas necessárias.</br>
Abra o projeto em sua IDE preferida.</br>
Configure as informações de conexão com o banco de dados no arquivo de configuração apropriado.</br>
Compile e execute a classe Main para testar as funcionalidades do CRUD.</br>
### Conclusão
Este projeto apresenta um exemplo de implementação de um CRUD em uma Área Administrativa, utilizando conceitos avançados de programação orientada a objetos, boas práticas de programação e integração com um banco de dados relacional. Ele serve como ponto de partida para o desenvolvimento de sistemas mais complexos e robustos, podendo ser adaptado e expandido conforme as necessidades específicas do seu projeto.
