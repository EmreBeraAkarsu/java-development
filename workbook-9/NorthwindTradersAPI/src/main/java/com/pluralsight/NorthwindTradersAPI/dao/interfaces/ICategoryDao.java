package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ICategoryDao {

    Category insert(Category category);

    List<Category> getAll();

    Category getById(int categoryId);

    void update(int categoryId, Category category);

    void delete(int categoryId);
}
