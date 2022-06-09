DROP DATABASE IF EXISTS ims;

CREATE DATABASE IF NOT EXISTS ims;

USE ims ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `itemsid` INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
    `itemsName` VARCHAR(40) NOT NULL,
    `price` DEC(10, 2) NOT NULL,
    PRIMARY KEY (`itemsid`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
      order_id INT NOT NULL AUTO_INCREMENT, 
      fk_id INT NOT NULL,
      PRIMARY KEY (order_id),
      FOREIGN KEY (fk_id) REFERENCES customers(id)
);

   CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
      order_itemsID INT NOT NULL,
      fk_order_id INT NOT NULL,
      fk_itemsid INT NOT NULL,
      quantity INT DEFAULT 1,
      PRIMARY KEY (order_itemsID),
      FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
      FOREIGN KEY (fk_itemsid) REFERENCES items(itemsid)
); 
