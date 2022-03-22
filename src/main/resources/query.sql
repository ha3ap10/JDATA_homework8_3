select o.product_name
from products.customers c
         join products.orders o on c.id = o.customer_id
where lower(c.name) = lower(:NameCustomer);
