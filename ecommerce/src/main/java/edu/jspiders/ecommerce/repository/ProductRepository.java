package edu.jspiders.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
