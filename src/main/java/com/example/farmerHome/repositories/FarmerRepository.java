package com.example.farmerHome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.farmerHome.entities.Farmer;

@Component
public interface FarmerRepository extends CrudRepository<Farmer, Integer> {}
