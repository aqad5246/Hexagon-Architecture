package com.b2b.techpulse.adapter.driving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2b.techpulse.application.port.api.OrderUseCase;
import com.b2b.techpulse.domain.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderUseCase orderApi;

    @Autowired
    public OrderController(OrderUseCase orderApi) {
        this.orderApi = orderApi;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderApi.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderApi.getOrderById(id);
    }
}