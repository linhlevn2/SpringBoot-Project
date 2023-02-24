package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.FoodCost;

@Repository
public interface CostRepository extends CrudRepository<FoodCost,Integer>{
}
