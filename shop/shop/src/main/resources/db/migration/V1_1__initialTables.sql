create table if not exists location(
id SERIAL UNIQUE,
name varchar(50),
address varchar(50),
city varchar(50),
county varchar(50),
street_address varchar(50),
PRIMARY KEY(id)
);

create table if not exists customer(
id SERIAL UNIQUE,
first_name varchar(50),
last_name varchar(50),
username varchar(50),
password varchar(50),
email_address varchar(50),
PRIMARY KEY(id)
);

create table if not exists revenue(
id SERIAL UNIQUE,
location_id SERIAL,
revenue_date DATE,
money_sum bigint,
PRIMARY KEY(id),
FOREIGN KEY (location_id) REFERENCES location(id)
);

create table if not exists orderr(
id SERIAL UNIQUE,
shipped_from_id SERIAL,
customer_id SERIAL,
created_at DATE,
country varchar(50),
city varchar(50),
county varchar(50),
street_address varchar(50),
PRIMARY KEY(id),
FOREIGN KEY(shipped_from_id) REFERENCES location(id),
FOREIGN KEY(customer_id) REFERENCES customer(id)
);

create table if not exists product_category(
id SERIAL UNIQUE,
name varchar(50),
description varchar(300),
PRIMARY KEY(id)
);

create table if not exists supplier(
id SERIAL UNIQUE,
name varchar(50),
PRIMARY KEY(id)
);
create table if not exists product(
id SERIAL UNIQUE,
name varchar(50),
description varchar(300),
price bigint,
weight double precision,
product_category_id SERIAL,
supplier_id SERIAL,
image_url varchar(100),
PRIMARY KEY(id),
FOREIGN KEY(product_category_id) REFERENCES product_category(id),
FOREIGN KEY(supplier_id) REFERENCES supplier(id)
);

create table if not exists stock(
product_id SERIAL,
location_id SERIAL,
quantity int,
FOREIGN KEY(product_id) REFERENCES product(id),
FOREIGN KEY(location_id) REFERENCES location(id)
);

create table if not exists order_detail(
order_id SERIAL,
product_id SERIAL,
quantity int,
FOREIGN KEY(order_id) REFERENCES orderr(id),
FOREIGN KEY(product_id) REFERENCES product(id)
);

create table if not exists customer_order(
customer_id SERIAL,
order_id SERIAL,
FOREIGN KEY(customer_id) REFERENCES customer(id),
FOREIGN KEY(order_id) REFERENCES orderr(id)

)
