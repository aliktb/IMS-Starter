INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`item_name`, `item_value`) VALUES ('apple', 8.4);

INSERT INTO `order_items` (`order_items_id`, `order_id`, `customer_id`, `item_id`) VALUES (1,1,1,1);

INSERT INTO `orders` (`order_id`,`customer_id`,`total_order_cost`) VALUES (1,1,1);