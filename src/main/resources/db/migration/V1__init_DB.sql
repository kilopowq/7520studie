create table Address (
  id  bigserial not null,
  apartment int4,
  city varchar(255) not null,
  house varchar(255) not null,
  street varchar(255) not null,
  primary key (id));

create table Category (
  id  bigserial not null,
  name varchar(255) not null,
  primary key (id));

create table OrderProduct (
  id  bigserial not null,
  amount int4 not null,
  order_id int8,
  product_id int8,
  primary key (id));

create table orders (
  id  bigserial not null,
  date timestamp not null,
  orderStatus varchar(255),
  sum float8 not null,
  user_id int8,
  primary key (id));

create table Producer (
  id  bigserial not null,
  name varchar(255) not null,
  primary key (id));

create table Product (
  id  bigserial not null,
  description varchar(255),
  name varchar(255) not null,
  price int4 not null,
  category_id int8,
  producer_id int8,
  primary key (id));

create table users (
  id  bigserial not null,
  email varchar(255) not null,
  middlename varchar(255) not null,
  name varchar(255) not null,
  phone int8 not null,
  registrationDate timestamp not null,
  sername varchar(255) not null,
  address_id int8,
  primary key (id));

alter table Category
  add constraint category_name_un
unique (name);

alter table OrderProduct
  add constraint order_product_un
unique (order_id, product_id);

alter table OrderProduct
  add constraint order_product_order_fk
foreign key (order_id) references orders;

alter table OrderProduct
  add constraint order_product_product_fk
foreign key (product_id) references Product;

alter table orders
  add constraint order_user_fk
foreign key (user_id) references users;

alter table Producer
  add constraint producer_name_un
unique (name);

alter table Product
  add constraint product_category_fk
foreign key (category_id) references Category;

alter table Product
  add constraint product_producer_fk
foreign key (producer_id) references Producer;

alter table users
  add constraint user_email_un
unique (email);

alter table users
  add constraint user_address_fk
foreign key (address_id) references Address;
