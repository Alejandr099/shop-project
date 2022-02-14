package wszib.project.shop.service;

import wszib.project.shop.domain.Category;

import java.util.List;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
