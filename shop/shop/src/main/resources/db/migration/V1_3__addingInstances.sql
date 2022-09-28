INSERT INTO product_category(name,description)
VALUES('Shoes','Everyone knows what shoes are');

INSERT INTO product_category(name,description)
VALUES('Coke','The kind you drink');

INSERT INTO supplier(name)
VALUES('Coca Cola');

INSERT INTO supplier(name)
VALUES('Decathlon');

INSERT INTO product(name,description,price,weight,product_category_id,supplier_id,image_url)
VALUES('Diet Coke','Zero Calories',2,0.3,2,1,'invalid/url');

INSERT INTO product(name,description,price,weight,product_category_id,supplier_id,image_url)
VALUES('Sneakers','Running Shoes',40,0.1,1,2,'invalid/url');