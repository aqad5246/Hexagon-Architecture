package com.b2b.techpulse.application.service;

import org.springframework.stereotype.Service;

import com.b2b.techpulse.domain.model.Order;
import com.b2b.techpulse.application.port.api.OrderUseCase;
import com.b2b.techpulse.application.port.persistence.OrderRepository;

@Service
public class OrderService implements OrderUseCase {
    private final OrderRepository orderRepository;
    
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // @Override
    // public Order createOrder(String description, double amount) {
    //     Order order = new Order(new OrderId(), description, amount);
    //     return orderRepository.save(order);
    // }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
    
}
