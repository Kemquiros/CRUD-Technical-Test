
/**
 * Author:  t30r3m4
 * Created: 14/12/2016
 */
CREATE DATABASE IF NOT EXISTS app2DB;
USE app2DB;
DROP TABLE IF EXISTS login, products, clients;
CREATE TABLE login(
id INT NOT NULL AUTO_INCREMENT,
userName VARCHAR(255),
password VARCHAR(255),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE products(
id INT NOT NULL AUTO_INCREMENT,
productName VARCHAR(255),
quantity INT,
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE clients(
id INT NOT NULL AUTO_INCREMENT,
clientName VARCHAR(255),
city VARCHAR(255),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO login VALUES(1,'admin','123');
INSERT INTO products VALUES(1,'Desk','25');
INSERT INTO products VALUES(2,'Table','47');
INSERT INTO products VALUES(3,'Chair','70');
INSERT INTO clients VALUES(100,'Sam','Medellin');
INSERT INTO clients VALUES(222,'Jorge','Bogota');
INSERT INTO clients VALUES(332,'Alejandro','Barranquilla');
commit;



