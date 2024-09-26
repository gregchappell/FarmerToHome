package com.example.farmerHome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.example.farmerHome.entities.Consumer;

@Component
public interface ConsumerRepository extends CrudRepository<Consumer, Integer>{}
