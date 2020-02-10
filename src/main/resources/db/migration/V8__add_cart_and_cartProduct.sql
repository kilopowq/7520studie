create table CartProduct (
  id bigserial not null,
  amount int4 not null,
  cart_id int8,
  product_id int8,
  primary key (id));

create table Cart (
  id bigserial not null,
  date timestamp not null,
  cartStatus varchar(255),
  user_id int8,
  primary key (id));

alter table CartProduct
  add constraint cart_product_un
unique (cart_id, product_id);

alter table CartProduct
  add constraint cart_product_cart_fk
foreign key (cart_id) references Cart;

alter table CartProduct
  add constraint cart_product_product_fk
foreign key (product_id) references Product;

alter table Cart
  add constraint cart_user_fk
foreign key (user_id) references users;
