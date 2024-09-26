package com.example.farmerHome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.example.farmerHome.entities.Basket;

@Component
public interface BasketRepository extends CrudRepository<Basket, Integer>{}
