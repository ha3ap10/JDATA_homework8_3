select o.product_name
from products.CUSTOMERS c
         join products.ORDERS o on c.id = o.customer_id
where lower(c.name) = lower(:NameCustomer);
