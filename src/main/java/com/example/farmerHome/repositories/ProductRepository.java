package com.example.farmerHome.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.farmerHome.entities.Product;

@Component
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	//Select/filter queries
	public List<Product> findByCategory(Integer categoryId);
	
	public List<Product> findByPrice(Double min, Double max);
	
	public List<Product> findByExpiryDate(Integer min, Integer max);	
}
