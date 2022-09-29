
create table if not exists location(
id SERIAL UNIQUE,
name varchar(50),
country varchar(50),
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


create table if not exists orderr(
id SERIAL UNIQUE,
shipped_from_id BIGINT,
customer_id BIGINT,
location_id BIGINT,
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
product_category_id BIGINT,
supplier_id BIGINT,
image_url varchar(100),
PRIMARY KEY(id),
FOREIGN KEY(product_category_id) REFERENCES product_category(id),
FOREIGN KEY(supplier_id) REFERENCES supplier(id)
);

create table if not exists stock(
product_id BIGINT,
location_id BIGINT,
quantity int,
FOREIGN KEY(product_id) REFERENCES product(id),
FOREIGN KEY(location_id) REFERENCES location(id)
);

create table if not exists order_detail(
order_id BIGINT,
product_id BIGINT,
quantity int,
FOREIGN KEY(order_id) REFERENCES orderr(id),
FOREIGN KEY(product_id) REFERENCES product(id)
);


