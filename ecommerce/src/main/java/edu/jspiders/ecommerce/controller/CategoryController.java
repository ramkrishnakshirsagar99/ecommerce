package edu.jspiders.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jspiders.ecommerce.entity.Category;
import edu.jspiders.ecommerce.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public String createCategory(Category category) {
		return categoryService.createCategory(category);
	}
	@GetMapping
	public Page<Category> getAllCategories(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
	) {
	    return categoryService.getAllCategories(page, size);
	}
	@GetMapping("/{id}")
	public Category findById(@PathVariable long id) {
		return categoryService.findById(id);
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable Long id, @RequestBody Category category) {
	     return categoryService.updateCategory(id, category);
    }
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
	     return categoryService.deleteCategory(id);
   }
}