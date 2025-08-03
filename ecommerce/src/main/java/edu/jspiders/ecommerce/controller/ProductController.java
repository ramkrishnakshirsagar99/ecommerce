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
import edu.jspiders.ecommerce.entity.Product;
import edu.jspiders.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@PostMapping
	public String createProduct(Product product) {
		return productService.createProduct(product);
	}
	@GetMapping
	public Page<Category> getAllProducts(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
	) {
	    return productService.getAllProducts(page, size);
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable long id) {
		return productService.findById(id);
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable Long id, @RequestBody Product product) {
	     return productService.updateCategory(id, product);
    }
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
	     return productService.deleteCategory(id);
   }
}
