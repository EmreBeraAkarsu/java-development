package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    List<Category> categories;

    public CategoriesController() {

        categories = new ArrayList<>();

        categories.add(new Category(232, "fffwgewrg"));
        categories.add(new Category(222, "gggg"));
        categories.add(new Category(132, "fffggffssswgewrg"));
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categories;
    }
}
