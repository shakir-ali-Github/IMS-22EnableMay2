INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`itemsName`, `price`) VALUES ('Laptop', '249.99');
INSERT INTO `orders` (`fk_id`) VALUES ('1');
INSERT INTO `orders_items` (`fk_order_id`, `fk_itemsID`, `quantity`) VALUES ('1', '1', '5');