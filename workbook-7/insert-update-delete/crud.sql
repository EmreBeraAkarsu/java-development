use northwind;

-- 1) 
insert into suppliers
 Values(1000000, 'Kazim', 'Mahmut', 'Manager', '123 Main st', 'Lancaster', 'PA', '17601', 'USA', '7272226633', '634562365', 'www.kazimkarabekir.com');
 


-- 2) 
insert into products
 Values(4213423, 'sahlep', 1000000, 1, '6 pack', 24, 43, 0, 10, 0);


-- 3) 
select *
from products p
inner join suppliers s on p.SupplierID = s.SupplierID;

-- 4) 
update products
set UnitPrice = (UnitPrice * 1.15)
where ProductID = 4213423;


-- 5) 
select ProductName, UnitPrice
from products
where SupplierID = 1000000;


-- 6) 
delete from products
where ProductID = 4213423;


-- 7) 
delete from suppliers
where SupplierID = 1000000;


-- 8) 
select *
from products;


-- 9) 
select *
from suppliers;