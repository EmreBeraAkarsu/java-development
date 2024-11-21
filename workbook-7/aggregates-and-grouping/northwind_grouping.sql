use northwind;

-- 1) 
select count(*)
from suppliers;

-- 2) 
select sum(Salary)
from employees;

-- 3) 
select min(UnitPrice)
from products;

-- 4) 
select avg(UnitPrice)
from products;

-- 5) 
select max(UnitPrice)
from products;

-- 6) 
select SupplierID, count(*)
from products
group by SupplierID;

-- 7) 
select CategoryID, avg(UnitPrice)
from products
group by CategoryID;

-- 8) 
select SupplierID, count(*)
from products
group by SupplierID
having count(*) >= 5;

-- 9) 
select ProductID, ProductName, (UnitPrice * UnitsInStock) as inventory_value
from products
order by inventory_value desc, ProductName;



