# DevSuperior DAO JDBC

Projeto de estudo desenvolvido em Java com o objetivo de praticar acesso a banco de dados utilizando JDBC e o padrão DAO.

## Sobre o projeto

Este projeto simula um sistema simples de cadastro de vendedores e departamentos.

A aplicação realiza operações básicas de CRUD no banco de dados, separando as responsabilidades entre:

- Entidades
- Classes DAO
- Implementações JDBC
- Classe de conexão com o banco
- Classe principal da aplicação

O projeto foi desenvolvido com finalidade educacional, durante os estudos de Java e banco de dados.

## Tecnologias utilizadas

- Java
- JDBC
- Maven
- MySQL

## Estrutura do projeto

```text
DevSuperior-DAO_JDBC
├── src
│   └── main
│       ├── java
│       │   ├── application
│       │   │   └── Main.java
│       │   ├── db
│       │   │   ├── DB.java
│       │   │   ├── DbException.java
│       │   │   └── DbIntegrityException.java
│       │   └── model
│       │       ├── dao
│       │       │   ├── impl
│       │       │   │   ├── DepartmentDaoJDBC.java
│       │       │   │   └── SellerDaoJDBC.java
│       │       │   ├── DaoFactory.java
│       │       │   ├── DepartmentDao.java
│       │       │   └── SellerDao.java
│       │       └── entities
│       │           ├── Department.java
│       │           └── Seller.java
│       └── resources
│           └── db.properties
├── pom.xml
└── README.md
```

## Funcionalidades

O projeto possui operações CRUD para vendedores e departamentos.

### Vendedores

- Buscar vendedor por ID
- Buscar vendedores por departamento
- Listar todos os vendedores
- Inserir vendedor
- Atualizar vendedor
- Remover vendedor

### Departamentos

- Buscar departamento por ID
- Listar todos os departamentos
- Inserir departamento
- Atualizar departamento
- Remover departamento

## Conceitos praticados

- Programação orientada a objetos
- JDBC
- Padrão DAO
- Padrão Factory
- Interfaces
- Implementação de interfaces
- CRUD com banco de dados
- PreparedStatement
- ResultSet
- Tratamento de exceções
- Organização do projeto em camadas
- Relacionamento entre tabelas

## Configuração do banco de dados

O projeto utiliza um arquivo chamado `db.properties` dentro da pasta:

```text
src/main/resources
```

Exemplo de configuração:

```properties
user=seu_usuario
password=sua_senha
dburl=jdbc:mysql://localhost:3306/coursejdbc?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
```

Altere o usuário, senha e nome do banco de acordo com a configuração do seu ambiente.

## Modelo do banco de dados

O projeto utiliza duas tabelas principais:

- `department`
- `seller`

A tabela `seller` possui uma chave estrangeira para `department`.

Exemplo de criação das tabelas:

```sql
CREATE DATABASE coursejdbc;

USE coursejdbc;

CREATE TABLE department (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60) DEFAULT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE seller (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    BirthDate DATETIME NOT NULL,
    BaseSalary DOUBLE NOT NULL,
    DepartmentId INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```

Exemplo de dados iniciais:

```sql
INSERT INTO department (Name) VALUES
('Computers'),
('Electronics'),
('Fashion'),
('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES
('Bob Brown', 'bob@gmail.com', '1998-04-21', 1000.0, 1),
('Maria Green', 'maria@gmail.com', '1979-12-31', 3500.0, 2),
('Alex Gray', 'alex@gmail.com', '1988-01-15', 2200.0, 1),
('Martha Wayne', 'martha@gmail.com', '1993-11-30', 3000.0, 4),
('Sam Black', 'sam@gmail.com', '2000-01-09', 4000.0, 3),
('Jose Blue', 'jose@gmail.com', '1997-03-04', 3000.0, 2);
```

## Como executar o projeto

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/DevSuperior-DAO_JDBC.git
```

Acesse a pasta do projeto:

```bash
cd DevSuperior-DAO_JDBC
```

Configure o arquivo `db.properties` com os dados do seu banco.

Depois, execute a classe principal do projeto pela sua IDE.

Também é possível compilar o projeto com Maven:

```bash
mvn compile
```

## Observação

Este projeto foi desenvolvido apenas para fins de estudo.

Algumas operações executadas na classe principal alteram os dados do banco, como inserção, atualização e remoção. Por isso, é recomendado utilizar um banco de dados de teste.

## Autor

Projeto desenvolvido durante os estudos de Java, JDBC e banco de dados.

## Licença

Este projeto é de uso educacional.
