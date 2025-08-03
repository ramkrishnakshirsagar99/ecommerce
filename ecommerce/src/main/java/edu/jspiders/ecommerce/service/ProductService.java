package edu.jspiders.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import edu.jspiders.ecommerce.entity.Category;
import edu.jspiders.ecommerce.entity.Product;

@Service
public interface ProductService {

	String createProduct(Product product);

	Page<Category> getAllProducts(int page, int size);

	Product findById(long id);

	String updateCategory(Long id, Product product);

	String deleteCategory(Long id);

}
