insert into products.CUSTUMERS (name, surname, age, phone_number)
values ('Alexey', 'Nazarenko', 32, 89260008899),
       ('Vasya', 'Ivanov', 25, 89095653214),
       ('Ivan', 'Vasilev', 35, 89095653225),
       ('Petya', 'Sidorov', 40, 89095653247),
       ('Masha', 'Petrova', 20, 89095653269),
       ('Sveta', 'Ivanova', 29, 89095653236);

insert into products.ORDERS (customer_id, product_name, amount)
values (1, 'productName', 10),
       (2, 'productName1', 10),
       (1, 'productName1', 10),
       (2, 'productName2', 10),
       (1, 'productName3', 10),
       (3, 'productName', 10),
       (1, 'productName2', 10),
       (4, 'productName', 10),
       (1, 'productName4', 10);