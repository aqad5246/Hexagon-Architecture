package com.b2b.techpulse.application.port.persistence;
import com.b2b.techpulse.domain.model.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(Long id);
    // Order findById(Long id);
    Order save(Order order);
}
