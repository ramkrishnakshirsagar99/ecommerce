package edu.jspiders.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import edu.jspiders.ecommerce.entity.Category;

@Service
public interface CategoryService {

	public String createCategory(Category category);

	public Category findById(long id);

	public String updateCategory(Long id, Category category);

	public String deleteCategory(Long id);

	public Page<Category> getAllCategories(int page, int size);


}
