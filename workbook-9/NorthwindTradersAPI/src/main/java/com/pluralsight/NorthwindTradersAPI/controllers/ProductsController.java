package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductsController {
    List<Product> products;

    public ProductsController() {
        products = new ArrayList<>();

        products.add(new Product(34, "Adfds", 42, 37.44));
        products.add(new Product(14, "fgfg", 35, 38.44));
        products.add(new Product(24, "jjkkk", 62, 39.44));

    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return products;
    }

}
