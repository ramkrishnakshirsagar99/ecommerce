package edu.jspiders.ecommerce.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.jspiders.ecommerce.Dao.CategoryDao;
import edu.jspiders.ecommerce.entity.Category;
import edu.jspiders.ecommerce.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public String createCategory(Category category) {
		Category newCategory= categoryDao.createCategory(category);
		
		if(newCategory!=null) {
			return newCategory.getName()+" Added Sucessfully";
		}
		return "Category Not Added";
	}

	@Override
	public Category findById(long id) {
		Optional<Category> category = categoryDao.findById(id);
		if(category.isPresent()) {
			return category.get();
		}else {
			return null;
		}
		
	}

	@Override
	public String updateCategory(Long id, Category category) {
		Optional<Category> existingCategory = categoryDao.findById(id);
		if(existingCategory.isPresent()) {
			Category newCategory = existingCategory.get();
			newCategory.setId(category.getId());
			newCategory.setName(category.getName());
			newCategory.setProducts(category.getProducts());
			
			return "Category Updated Sucessfully";
		}
		return "Category Not found";
	}

	@Override
	public String deleteCategory(Long id) {
		Optional<Category> category = categoryDao.findById(id);
		if(category.isPresent()) {
			categoryDao.deleteById(id);
			return "Category Deleted Sucessfully";
		}
		return "Category Not Found";
	}

	@Override
	public Page<Category> getAllCategories(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
		    return categoryDao.findAll(pageable);
	}
}
