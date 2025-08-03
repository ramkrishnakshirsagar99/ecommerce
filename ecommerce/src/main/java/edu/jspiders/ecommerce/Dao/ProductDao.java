package edu.jspiders.ecommerce.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import edu.jspiders.ecommerce.entity.Category;
import edu.jspiders.ecommerce.entity.Product;
import edu.jspiders.ecommerce.repository.ProductRepository;


@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
		
	}

	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
}
