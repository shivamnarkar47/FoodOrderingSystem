package com.foodOrdering.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.foodOrdering.backend.models.Order;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // @Query("{'username':?0}")
    public List<Order> findByUserName(String userName);
}
