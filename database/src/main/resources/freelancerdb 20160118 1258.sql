--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 6.3.358.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 18.01.2016 12:58:56
-- Версия сервера: 5.6.28-log
-- Версия клиента: 4.1
--


-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
USE freelancerdb;

--
-- Описание для таблицы admin
--
DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) DEFAULT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(50) DEFAULT NULL,
  last_name VARCHAR(50) DEFAULT NULL,
  lang ENUM('en','uk-UA') DEFAULT 'en',
  uuid VARCHAR(140) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  salt VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX uuid (uuid)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы customer
--
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(50) DEFAULT NULL,
  last_name VARCHAR(50) NOT NULL,
  zone TIMESTAMP NULL DEFAULT NULL,
  lang ENUM('en','uk-UA') DEFAULT 'en',
  uuid VARCHAR(140) DEFAULT NULL,
  reg_url VARCHAR(150) DEFAULT NULL,
  reg_date DATETIME DEFAULT NULL,
  version INT(11) NOT NULL DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  salt VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX email (email),
  UNIQUE INDEX reg_url (reg_url),
  UNIQUE INDEX uuid (uuid)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы developer
--
DROP TABLE IF EXISTS developer;
CREATE TABLE developer (
  id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  hourly DOUBLE DEFAULT NULL,
  zone TIMESTAMP NULL DEFAULT NULL,
  lang ENUM('en','uk-UA') DEFAULT 'en',
  uuid VARCHAR(140) DEFAULT NULL,
  reg_url VARCHAR(150) DEFAULT NULL,
  reg_date DATETIME DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  salt VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX reg_url (reg_url),
  UNIQUE INDEX uuid (uuid)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы technology
--
DROP TABLE IF EXISTS technology;
CREATE TABLE technology (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы contact
--
DROP TABLE IF EXISTS contact;
CREATE TABLE contact (
  id INT(11) NOT NULL AUTO_INCREMENT,
  cust_id INT(11) DEFAULT NULL,
  dev_id INT(11) DEFAULT NULL,
  phone VARCHAR(15) DEFAULT NULL,
  skype VARCHAR(255) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_contact_customer_id FOREIGN KEY (cust_id)
    REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_contact_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы dev_tech
--
DROP TABLE IF EXISTS dev_tech;
CREATE TABLE dev_tech (
  id INT(11) NOT NULL AUTO_INCREMENT,
  dev_id INT(11) DEFAULT NULL,
  tech_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_dev_tech_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_dev_tech_technology_id FOREIGN KEY (tech_id)
    REFERENCES technology(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы developer_qa
--
DROP TABLE IF EXISTS developer_qa;
CREATE TABLE developer_qa (
  id INT(11) NOT NULL AUTO_INCREMENT,
  dev_id INT(11) DEFAULT NULL,
  tech_id INT(11) DEFAULT NULL,
  rate FLOAT DEFAULT 0,
  expire DATE DEFAULT NULL,
  is_expire BIT(1) DEFAULT b'0',
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_developer_qa_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_developer_qa_technology_id FOREIGN KEY (tech_id)
    REFERENCES technology(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы feedback
--
DROP TABLE IF EXISTS feedback;
CREATE TABLE feedback (
  id INT(11) NOT NULL AUTO_INCREMENT,
  dev_id INT(11) DEFAULT NULL,
  cust_id INT(11) DEFAULT NULL,
  comment VARCHAR(1000) DEFAULT NULL,
  rate INT(11) DEFAULT 0,
  author ENUM('dev','customer') NOT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_feedback_customer_id FOREIGN KEY (cust_id)
    REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_feedback_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы ordering
--
DROP TABLE IF EXISTS ordering;
CREATE TABLE ordering (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(120) NOT NULL,
  pay_type ENUM('hourly','fixed') DEFAULT 'fixed',
  descr VARCHAR(3000) DEFAULT NULL,
  customer_id INT(11) DEFAULT NULL,
  date DATETIME NOT NULL,
  payment FLOAT DEFAULT NULL,
  started BIT(1) DEFAULT b'0',
  started_date DATETIME DEFAULT NULL,
  ended BIT(1) DEFAULT b'0',
  ended_date DATETIME DEFAULT NULL,
  private BIT(1) DEFAULT b'0',
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_ordering_customer_id FOREIGN KEY (customer_id)
    REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы question
--
DROP TABLE IF EXISTS question;
CREATE TABLE question (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  tech_id INT(11) DEFAULT NULL,
  admin_id INT(11) DEFAULT NULL,
  multiple BIT(1) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_question_admin_id FOREIGN KEY (admin_id)
    REFERENCES admin(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_question_technology_id FOREIGN KEY (tech_id)
    REFERENCES technology(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы test
--
DROP TABLE IF EXISTS test;
CREATE TABLE test (
  id INT(11) NOT NULL DEFAULT 0,
  tech_id INT(11) DEFAULT NULL,
  name VARCHAR(50) DEFAULT NULL,
  admin_id INT(11) DEFAULT NULL,
  pass_score TINYINT(4) DEFAULT NULL,
  sec_per_quest INT(11) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_test_admin_id FOREIGN KEY (admin_id)
    REFERENCES admin(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_test_technology_id FOREIGN KEY (tech_id)
    REFERENCES technology(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы answer
--
DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
  id INT(11) NOT NULL AUTO_INCREMENT,
  quest_id INT(11) DEFAULT NULL,
  correct BIT(1) NOT NULL DEFAULT b'0',
  name VARCHAR(100) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_answer_question_id FOREIGN KEY (quest_id)
    REFERENCES question(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы follower
--
DROP TABLE IF EXISTS follower;
CREATE TABLE follower (
  id INT(11) NOT NULL AUTO_INCREMENT,
  dev_id INT(11) DEFAULT NULL,
  message VARCHAR(1000) DEFAULT NULL,
  order_id INT(11) DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_follower_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_follower_ordering_id FOREIGN KEY (order_id)
    REFERENCES ordering(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы test_question
--
DROP TABLE IF EXISTS test_question;
CREATE TABLE test_question (
  id INT(11) NOT NULL AUTO_INCREMENT,
  test_id INT(11) DEFAULT NULL,
  quest_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_test_question_question_id FOREIGN KEY (quest_id)
    REFERENCES question(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_test_question_test_id FOREIGN KEY (test_id)
    REFERENCES test(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы worker
--
DROP TABLE IF EXISTS worker;
CREATE TABLE worker (
  id INT(11) NOT NULL AUTO_INCREMENT,
  order_id INT(11) DEFAULT NULL,
  dev_id INT(11) DEFAULT NULL,
  new_hourly FLOAT DEFAULT NULL,
  sum_hours FLOAT DEFAULT NULL,
  version INT(11) DEFAULT 0,
  is_deleted BIT(1) DEFAULT b'0',
  PRIMARY KEY (id),
  CONSTRAINT FK_salary_developer_id FOREIGN KEY (dev_id)
    REFERENCES developer(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_salary_ordering_id FOREIGN KEY (order_id)
    REFERENCES ordering(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'entity that represents developers on some project';

-- 
-- Вывод данных для таблицы admin
--

-- Таблица freelancerdb.admin не содержит данных

-- 
-- Вывод данных для таблицы customer
--

-- Таблица freelancerdb.customer не содержит данных

-- 
-- Вывод данных для таблицы developer
--

-- Таблица freelancerdb.developer не содержит данных

-- 
-- Вывод данных для таблицы technology
--

-- Таблица freelancerdb.technology не содержит данных

-- 
-- Вывод данных для таблицы contact
--

-- Таблица freelancerdb.contact не содержит данных

-- 
-- Вывод данных для таблицы dev_tech
--

-- Таблица freelancerdb.dev_tech не содержит данных

-- 
-- Вывод данных для таблицы developer_qa
--

-- Таблица freelancerdb.developer_qa не содержит данных

-- 
-- Вывод данных для таблицы feedback
--

-- Таблица freelancerdb.feedback не содержит данных

-- 
-- Вывод данных для таблицы ordering
--

-- Таблица freelancerdb.ordering не содержит данных

-- 
-- Вывод данных для таблицы question
--

-- Таблица freelancerdb.question не содержит данных

-- 
-- Вывод данных для таблицы test
--

-- Таблица freelancerdb.test не содержит данных

-- 
-- Вывод данных для таблицы answer
--

-- Таблица freelancerdb.answer не содержит данных

-- 
-- Вывод данных для таблицы follower
--

-- Таблица freelancerdb.follower не содержит данных

-- 
-- Вывод данных для таблицы test_question
--

-- Таблица freelancerdb.test_question не содержит данных

-- 
-- Вывод данных для таблицы worker
--

-- Таблица freelancerdb.worker не содержит данных

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;