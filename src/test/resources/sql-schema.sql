DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `orders_items`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `itemsid` INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
    `itemsName` VARCHAR(40) NOT NULL,
    `price` DEC(10, 2) NOT NULL,
    PRIMARY KEY (`itemsid`)
);

CREATE TABLE IF NOT EXISTS `orders` (
      order_id INT NOT NULL AUTO_INCREMENT, 
      fk_id INT NOT NULL,
      PRIMARY KEY (order_id),
      FOREIGN KEY (fk_id) REFERENCES customers(id) ON DELETE CASCADE
);

   CREATE TABLE IF NOT EXISTS `orders_items` (
      order_itemsID INT NOT NULL AUTO_INCREMENT,
      fk_order_id INT NOT NULL,
      fk_itemsid INT NOT NULL,
      quantity INT DEFAULT 1,
      PRIMARY KEY (order_itemsID),
      FOREIGN KEY (fk_order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
      FOREIGN KEY (fk_itemsid) REFERENCES items(itemsid) ON DELETE CASCADE
); 
