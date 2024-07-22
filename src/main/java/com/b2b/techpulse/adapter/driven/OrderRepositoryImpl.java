package com.b2b.techpulse.adapter.driven;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2b.techpulse.application.port.persistence.OrderRepository;
import com.b2b.techpulse.domain.model.Order;

@Repository
public interface OrderRepositoryImpl extends JpaRepository <Order, Long>, OrderRepository{
}

// @Repository
// public class OrderRepositoryImpl implements OrderRepository {

//     private final Map<OrderId, Order> orderDatabase = new HashMap<>();

//     @Override
//     public Order save(Order order) {
//         orderDatabase.put(order.getId(), order);
//         return order;
//     }

//     @Override
//     public Order findById(OrderId id) {
//         return orderDatabase.get(id);
//     }
// }