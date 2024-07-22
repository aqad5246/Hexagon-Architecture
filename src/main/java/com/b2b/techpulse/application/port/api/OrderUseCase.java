package com.b2b.techpulse.application.port.api;

import com.b2b.techpulse.domain.model.Order;

public interface OrderUseCase {
    Order createOrder(Order order);
    Order getOrderById(Long id);
}