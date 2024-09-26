package com.example.farmerHome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.example.farmerHome.entities.Category;

@Component
public interface CategoryRepository extends CrudRepository<Category, Integer>{}
