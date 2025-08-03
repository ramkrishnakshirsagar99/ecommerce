package edu.jspiders.ecommerce.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.jspiders.ecommerce.Dao.ProductDao;
import edu.jspiders.ecommerce.entity.Product;
import edu.jspiders.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public String createProduct(Product product) {
        Product newProduct= productDao.createProduct(product);
		
		if(newProduct!=null) {
			return newProduct.getName()+" Added Sucessfully";
		}
		return "Product Not Added";
	}

	@Override
	public Page getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
	    return productDao.findAll(pageable);
	}

	@Override
	public Product findById(long id) {
		Optional<Product> product = productDao.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}

	@Override
	public String updateCategory(Long id, Product product) {
		Optional<Product> existingProduct = productDao.findById(id);
		if(existingProduct.isPresent()) {
			Product newProduct = existingProduct.get();
			newProduct.setId(product.getId());
			newProduct.setName(product.getName());
			newProduct.setPrice(product.getPrice());
			newProduct.setCategory(product.getCategory());
			
			return "Product Updated Sucessfully";
		}
		return "Product Not found";
	}

	@Override
	public String deleteCategory(Long id) {
		Optional<Product> existingProduct = productDao.findById(id);
		if(existingProduct.isPresent()) {
			productDao.deleteById(id);
			return "Product Deleted Sucessfully";
		}
		return "product Not Found";
	}
}
