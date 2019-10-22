# spring-boot-batch-mybatis
mybatis

```
docker pull mariadb/server:10.3

docker run -p 3306:3306 --name test -e MYSQL_ROOT_PASSWORD=test -d mariadb/server:10.3

```


```
GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' IDENTIFIED BY 'test';

CREATE DATABASE test;


```

```
CREATE TABLE people ( first_name varchar(20),last_name varchar(20));

INSERT INTO people (first_name, last_name) VALUES ('1', '2');
INSERT INTO people (first_name, last_name) VALUES ('1', '1');
INSERT INTO people (first_name, last_name) VALUES ('2', '3');
INSERT INTO people (first_name, last_name) VALUES ('2', '1');
INSERT INTO people (first_name, last_name) VALUES ('1', '3');
INSERT INTO people (first_name, last_name) VALUES ('2', '2');
INSERT INTO people (first_name, last_name) VALUES ('5', '6');
INSERT INTO people (first_name, last_name) VALUES ('5', '1');
INSERT INTO people (first_name, last_name) VALUES ('2', '5');
INSERT INTO people (first_name, last_name) VALUES ('6', '7');
INSERT INTO people (first_name, last_name) VALUES ('8', '8');

CREATE TABLE people2 ( first_name varchar(20),last_name varchar(20));


```