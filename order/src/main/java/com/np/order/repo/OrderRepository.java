package com.np.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.np.order.entity.Order;

//@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

}
