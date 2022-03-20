DROP DATABASE IF EXISTS `example`;
CREATE DATABASE `example`;
use example;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`
(
    `ID`   int(11)      NOT NULL,
    `NAME` varchar(255) NOT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8MB4;

insert into item
values (1, 'example-item-1');

insert into item
values (2, 'example-item-2');
