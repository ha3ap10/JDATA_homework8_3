create schema if not exists products;

create table products.CUSTUMERS
(
    id           serial primary key not null,
    name         varchar(50)        not null,
    surname      varchar(50)        not null,
    age          int                not null,
    phone_number bigint
);

create table products.ORDERS
(
    id           serial primary key      not null,
    date         timestamp default now() not null,
    customer_id  bigint unsigned,
    product_name varchar(100),
    amount       int,
    foreign key (customer_id) references CUSTUMERS (id)
);