ALTER TABLE order_detail
ADD PRIMARY KEY (order_id,product_id);

ALTER TABLE stock
ADD PRIMARY KEY (location_id,product_id);