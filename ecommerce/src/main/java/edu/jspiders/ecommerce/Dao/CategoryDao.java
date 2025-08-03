package edu.jspiders.ecommerce.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import edu.jspiders.ecommerce.entity.Category;
import edu.jspiders.ecommerce.repository.CategoryRepository;

@Repository
public class CategoryDao {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Optional<Category> findById(long id) {
		return categoryRepository.findById(id);
		
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
}
