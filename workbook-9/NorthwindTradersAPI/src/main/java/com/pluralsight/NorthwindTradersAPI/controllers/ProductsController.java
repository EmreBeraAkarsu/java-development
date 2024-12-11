package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDao;

@RestController
public class ProductsController {

    private final IProductDao productDao;
    public ProductsController(IProductDao productDao) {

        this.productDao = productDao;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

/*    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer categoryId,
                                        @RequestParam(required = false) Double price) {
        List<Product> filteredProducts = products;

        // Filter by name if provided
        if (name != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }

        // Filter by categoryId if provided
        if (categoryId != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getCategoryId() == categoryId)
                    .collect(Collectors.toList());
        }

        // Filter by price if provided
        if (price != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getUnitPrice() == price)
                    .collect(Collectors.toList());
        }

        return filteredProducts;
    }*/

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        return productDao.getById(productId);
    }


    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addAProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }
}