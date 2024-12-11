package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ICategoryDao;
import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private final ICategoryDao categoryDao;

    public CategoriesController(ICategoryDao categoryDao) {

        this.categoryDao = categoryDao;

    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

/*    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(@RequestParam(required = false) String name) {
        if (name != null) {
            return categories.stream()
                    .filter(c -> c.getCategoryName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }
        return categories;
    }*/

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryDao.getById(categoryId);
    }


    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addACategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }
}