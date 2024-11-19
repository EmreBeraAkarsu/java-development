-- 1-)
-- products

-- 2-)
select ProductID, ProductName, UnitPrice
from northwind.products;

-- 3-)
select ProductID, ProductName, UnitPrice
from northwind.products
order by UnitPrice asc;

-- 4-)
select *
from northwind.products
where UnitPrice <= 7.5;

-- 5-)
select *
from northwind.products
where UnitsInStock >= 100
order by UnitPrice desc;

-- 6-)
select *
from northwind.products
where UnitsInStock >= 100
order by UnitPrice desc, ProductName;

-- 7-)
select *
from northwind.products
where UnitsInStock = 0 and UnitsOnOrder >= 1
order by ProductName;

-- 8-)
-- categories

-- 9-)
select *
from northwind.categories;

select CategoryID
from northwind.categories
where CategoryName = "Seafood";

-- 10-)
select *
from northwind.products
where CategoryID = 8;

-- 11-)
select FirstName, LastName
from northwind.employees;

-- 12-)
select *
from northwind.employees
where Title like "%manager%";

-- 13-)
select distinct Title
from northwind.employees;

-- 14-)
select *
from northwind.employees
where Salary between 2000 and 2500;

-- 15-)
select *
from northwind.suppliers;

-- 16-)
select *
from northwind.products
where SupplierID = 4;

