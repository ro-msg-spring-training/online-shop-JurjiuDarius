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

INSERT INTO customer(email_address,first_name,last_name,"password",username)
VALUES('darius.jurjiu@yahoo.com','Darius','Jurjiu','pas123','DariusUser');

INSERT INTO customer(email_address,first_name,last_name,"password",username)
VALUES('johndoe@gmail.com','John','Doe','john','JohnUser');

INSERT INTO location(city,country,county,"name",street_address)
VALUES('Deva','Romania','Hunedoara','DevaSupplierSRL','Str. Depozitelor nr. 13');

INSERT INTO location(city,country,county,"name",street_address)
VALUES('Cluj-Napoca','Romania','Cluj','ClujSupplierSRL','Str. Depozitelor nr. 13');

INSERT INTO stock(location_id,product_id,quantity)
VALUES(1,1,100);

INSERT INTO stock(location_id,product_id,quantity)
VALUES(1,2,240);

INSERT INTO stock(location_id,product_id,quantity)
VALUES(2,1,200);

INSERT INTO stock(location_id,product_id,quantity)
VALUES(2,2,90);

