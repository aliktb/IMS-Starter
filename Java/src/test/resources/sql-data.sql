INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`item_name`, `item_value`) VALUES ('apple', 8.4);

INSERT INTO `order_items` ( `order_id`, `customer_id`, `item_id`) VAULES (1,1,1);

-- INSERT INTO `orders` SELECT `order_id`,`customer_id`, SUM(`item_value`) AS `total_order_cost` FROM `order_items` AS `oi` INNER JOIN `items` AS `it` ON `oi.item_id`=`it.id` WHERE `order_id` = 1 GROUP BY `order_id`;

INSERT INTO `orders` (`order_id`,`customer_id`,`total_order_cost`) VALUES (1,1,1);