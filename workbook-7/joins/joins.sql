-- 1) 
select p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName
from products p
inner join categories c on p.CategoryID = c.CategoryID
order by CategoryName, ProductName;


-- 2) 
select p.ProductID, p.ProductName, p.UnitPrice, s.CompanyName
from products p
inner join suppliers s on p.SupplierID = s.SupplierID
where p.UnitPrice > 75
order by p.ProductName;


-- 3) 
select p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName, s.CompanyName
from products p
inner join categories c on c.CategoryID = p.CategoryID
inner join suppliers s on s.SupplierID = p.SupplierID
order by p.ProductName;

-- 4) 
select p.ProductName, c.CategoryName
from products p
inner join categories c on p.CategoryID = c.CategoryID
where p.UnitPrice = (select max(UnitPrice)
						from products);


-- 5) 
select o.OrderID, o.ShipName, o.ShipAddress, s.CompanyName
from orders o
inner join shippers s on o.ShipVia = s.ShipperID
where o.ShipCountry = "Germany";

-- 6) 
select o.OrderID, o.OrderDate, o.ShipName, o.ShipAddress
from orders o
inner join `order details` od on o.OrderID = od.OrderID 
where od.ProductID = (select ProductID
						from products
                        where ProductName = "Sasquatch Ale");
                        
                        
                        
                     
 


