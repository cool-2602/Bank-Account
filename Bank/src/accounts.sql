CREATE DATABASE bankaccounts;

USE bankaccounts;

CREATE TABLE accounts
(AccountNumber INT PRIMARY KEY NOT NULL,
AccountHolderName VARCHAR(255),
MobileNo INT,
EmailID VARCHAR(255),
Balance FLOAT,
Password VARCHAR(255));

ALTER TABLE accounts AUTO_INCREMENT = 23457;

SELECT * FROM accounts;