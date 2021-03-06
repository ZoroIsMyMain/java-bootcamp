package com.shopcart.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shopcart.api.model.Product;

@Repository
public interface ProductShopRepository extends JpaRepository<Product, Long>{
	List<Product> findAll();
}
