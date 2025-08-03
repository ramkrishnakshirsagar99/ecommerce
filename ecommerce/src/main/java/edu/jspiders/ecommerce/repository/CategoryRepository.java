package edu.jspiders.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.ecommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
