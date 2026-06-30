# DevSuperior DAO JDBC

Study project developed in Java to practice database access using JDBC and the DAO pattern.

## About the project

This project simulates a simple system for managing sellers and departments.

The application performs basic CRUD operations in the database, separating responsibilities between:

- Entities
- DAO classes
- JDBC implementations
- Database connection class
- Main application class

This project was developed for educational purposes while studying Java and databases.

## Technologies used

- Java
- JDBC
- Maven
- MySQL

## Project structure

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

## Features

The project includes CRUD operations for sellers and departments.

### Sellers

- Find seller by ID
- Find sellers by department
- List all sellers
- Insert seller
- Update seller
- Delete seller

### Departments

- Find department by ID
- List all departments
- Insert department
- Update department
- Delete department

## Concepts practiced

- Object-oriented programming
- JDBC
- DAO pattern
- Factory pattern
- Interfaces
- Interface implementations
- CRUD operations with a database
- PreparedStatement
- ResultSet
- Exception handling
- Layered project organization
- Relationship between database tables

## Database configuration

The project uses a file named `db.properties` inside the following folder:

```text
src/main/resources
```

Configuration example:

```properties
user=your_user
password=your_password
dburl=jdbc:mysql://localhost:3306/coursejdbc?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
```

Change the user, password, and database name according to your local environment.

## Database model

The project uses two main tables:

- `department`
- `seller`

The `seller` table has a foreign key referencing `department`.

Example table creation script:

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

Example initial data:

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

## How to run the project

Clone the repository:

```bash
git clone https://github.com/your-username/DevSuperior-DAO_JDBC.git
```

Enter the project folder:

```bash
cd DevSuperior-DAO_JDBC
```

Configure the `db.properties` file with your database information.

Then run the main class using your IDE.

You can also compile the project with Maven:

```bash
mvn compile
```

## Notes

This project was developed for study purposes only.

Some operations executed in the main class change database records, such as insert, update, and delete operations. For this reason, it is recommended to use a test database.

## Author

Project developed while studying Java, JDBC, and databases.

## License

This project is for educational use.
