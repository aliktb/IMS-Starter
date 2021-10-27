DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `order_items`;
DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(50) DEFAULT NULL,
    `item_value` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `order_items` (

`order_items_id` INT(11) NOT NULL AUTO_INCREMENT,
`order_id` INT(11) NOT NULL,
`customer_id` INT(11) NOT NULL,
`item_id` INT(11) NOT NULL,
PRIMARY KEY (`order_items_id`)

);

CREATE TABLE IF NOT EXISTS `orders`(

`order_id` INT(11) NOT NULL AUTO_INCREMENT,
`customer_id` INT(11) NOT NULL,
`total_order_cost` FLOAT(11) NOT NULL,
PRIMARY KEY (order_id)

);