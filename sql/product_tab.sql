show databases;
use bootdemo;

desc product_tab;

INSERT INTO 
	bootdemo.product_tab (pcost, pid, pname) 
VALUES (100.00, 10, 'P1');

INSERT INTO 
	bootdemo.product_tab (pcost, pid, pname) 
VALUES (200.00, 11, 'P2');

-- AI Gen 
INSERT INTO bootdemo.product_tab (pcost, pid, pname)
VALUES
    (999.00, 10, 'Wireless Mouse'),
    (1499.00, 11, 'Mechanical Keyboard'),
    (2499.00, 12, 'Bluetooth Headphones'),
    (799.00, 13, 'USB-C Hub'),
    (1299.00, 14, 'Webcam'),
    (599.00, 15, 'Laptop Stand'),
    (899.00, 16, 'Wireless Charger'),
    (3499.00, 17, 'Portable SSD'),
    (699.00, 18, 'USB-C Cable'),
    (1999.00, 19, 'Gaming Controller'),
    (4599.00, 20, 'Smart Watch'),
    (1799.00, 21, 'Power Bank'),
    (8999.00, 22, '27-inch Monitor'),
    (1299.00, 23, 'Bluetooth Speaker'),
    (599.00, 24, 'Phone Stand'),
    (2499.00, 25, 'Wi-Fi Router'),
    (3999.00, 26, 'Graphics Tablet'),
    (1099.00, 27, 'Noise Cancelling Earbuds'),
    (6999.00, 28, 'Laser Printer'),
    (1599.00, 29, 'External Hard Drive'),
    (2999.00, 30, 'Mechanical Gaming Keyboard'),
    (799.00, 31, 'LED Desk Lamp'),
    (1899.00, 32, 'USB Microphone'),
    (5499.00, 33, 'Android Tablet'),
    (9999.00, 34, 'Smartphone'),
    (15999.00, 35, 'Smart TV');

SELECT 
    *
FROM
    product_tab;
    
-- delete from product_tab;
-- delete from product_tab where pid=10;
-- delete from product_tab where pid=11;

SELECT 
    pt.pid, 
    pt.pname, 
    pt.pcost
FROM
    bootdemo.product_tab AS pt
ORDER BY pid;

SELECT 
    pt.pid, 
    pt.pname, 
    pt.pcost
FROM
    bootdemo.product_tab AS pt
ORDER BY pid desc;

-- first 3 rows
SELECT 
    pt.pid, 
    pt.pname, 
    pt.pcost
FROM
    bootdemo.product_tab AS pt
limit 3;

-- start from 5th row give 2 rows
SELECT 
    pt.pid, 
    pt.pname, 
    pt.pcost
FROM
    bootdemo.product_tab AS pt
limit 4,3; -- offset,count

-- 2nd most costly item
SELECT 
    pt.pid, pt.pname, pt.pcost
FROM
    bootdemo.product_tab AS pt
order by pt.pcost desc limit 1,1;

