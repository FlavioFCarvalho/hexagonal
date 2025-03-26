package com.reobotnet.hexagonal.adapters.out.repository;

import com.reobotnet.hexagonal.adapters.out.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <CustomerEntity, String>{
}
