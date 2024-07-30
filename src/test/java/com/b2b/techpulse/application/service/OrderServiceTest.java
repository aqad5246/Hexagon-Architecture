package com.b2b.techpulse.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.b2b.techpulse.application.port.persistence.OrderLogger;
import com.b2b.techpulse.application.port.persistence.OrderRepository;
import com.b2b.techpulse.domain.model.Order;

public class OrderServiceTest {
    private OrderRepository orderRepository;
    private OrderLogger orderLogger;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        orderLogger = mock(OrderLogger.class);
        orderService = new OrderService(orderRepository, orderLogger);
    }

    @Test
    void testCreateOrder() {
        String description = "New Order";
        int amount = 100;
        Order newOrder = new Order(description, amount);
        
        Order order = orderService.createOrder(newOrder);

        // Verify that the order was saved
        verify(orderRepository).save(any(Order.class));

        // Capture the order object passed to the save method
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository).save(orderCaptor.capture());
        Order capturedOrder = orderCaptor.getValue();

        assertEquals(order.hashCode(), capturedOrder.hashCode());

        // Verify that the order was logged
        verify(orderLogger).logOrder(any(Order.class));
    }

}



    

