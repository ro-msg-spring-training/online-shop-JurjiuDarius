create table if not exists location(
PRIMARY KEY(id),
id              SERIAL UNIQUE   NOT NULL,
name            VARCHAR(50)     NOT NULL,
country         VARCHAR(50)     NOT NULL,
city            VARCHAR(50)     NOT NULL,
county          VARCHAR(50)     NOT NULL,
street_address  VARCHAR(50)     NOT NULL
);

create table if not exists customer(
PRIMARY KEY(id),
id SERIAL UNIQUE     NOT NULL,
first_name      VARCHAR(50)     NOT NULL,
last_name       VARCHAR(50)     NOT NULL,
username        VARCHAR(50)     NOT NULL,
password        VARCHAR(50)     NOT NULL,
email_address   VARCHAR(50)     NOT NULL
);

create table if not exists orderr(
PRIMARY KEY(id),
id                  SERIAL UNIQUE   NOT NULL,
customer_id         INTEGER         NOT NULL,
location_id         INTEGER         NOT NULL,
created_at          DATE            NOT NULL,
country             VARCHAR(50)     NOT NULL,
city                VARCHAR(50)     NOT NULL,
county              VARCHAR(50)     NOT NULL,
street_address      VARCHAR(50)     NOT NULL,
FOREIGN KEY(location_id) REFERENCES location(id),
FOREIGN KEY(customer_id) REFERENCES customer(id)
);

create table if not exists product_category(
PRIMARY KEY(id),
id          SERIAL UNIQUE       NOT NULL,
name        VARCHAR(50)         NOT NULL,
description VARCHAR(300)        NOT NULL
);

create table if not exists supplier(
PRIMARY KEY(id),
id      SERIAL UNIQUE       NOT NULL,
name    VARCHAR(50)         NOT NULL
);

create table if not exists product(
PRIMARY KEY(id),
id                  SERIAL UNIQUE       NOT NULL,
name                VARCHAR(50)         NOT NULL,
description         VARCHAR(300)        NOT NULL,
price               INTEGER              NOT NULL,
weight              DOUBLE PRECISION    NOT NULL,
product_category_id INTEGER              NOT NULL,
supplier_id         INTEGER              NOT NULL,
image_url           VARCHAR(100)        NOT NULL,
FOREIGN KEY(product_category_id) REFERENCES product_category(id),
FOREIGN KEY(supplier_id) REFERENCES supplier(id)
);

create table if not exists stock(
product_id  INT         NOT NULL,
location_id INT         NOT NULL,
quantity    INT         NOT NULL,
FOREIGN KEY(product_id) REFERENCES product(id),
FOREIGN KEY(location_id) REFERENCES location(id)
);

create table if not exists order_detail(
order_id    INT         NOT NULL,
product_id  INT         NOT NULL,
quantity    INT         NOT NULL,
FOREIGN KEY(order_id) REFERENCES orderr(id),
FOREIGN KEY(product_id) REFERENCES product(id)
);


