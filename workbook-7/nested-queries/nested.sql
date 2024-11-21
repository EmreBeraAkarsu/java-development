use northwind;

-- 1) 
select ProductName
from products
where UnitPrice = (Select max(UnitPrice)
					from products);

-- 2) 
select OrderID, ShipName, ShipAddress
from orders
where ShipVia = (Select ShipperID
					from shippers
					where CompanyName = "Federal Shipping");

-- 3) 
Select OrderID
from `order details`
where ProductID = (Select ProductID
					from products
                    where ProductName like "Sasquatch Ale");

-- 4) 
select FirstName, LastName
from employees
where EmployeeID = (Select EmployeeID
					from orders
					where OrderID = 10266);

-- 5) 
select CompanyName
from customers
where CustomerID = (Select CustomerID
					from orders
					where OrderID = 10266);

