package com.b2b.techpulse.adapter.driving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.b2b.techpulse.application.port.api.OrderUseCase;
import com.b2b.techpulse.domain.model.Order;

@Component
public class OrderCommandLineRunner implements CommandLineRunner{
    private final OrderUseCase orderApi;

    @Autowired
    public OrderCommandLineRunner(OrderUseCase orderApi) {
        this.orderApi = orderApi;
    }

    @Override
    public void run(String... args) {
        if (args.length < 2) {
            System.out.println("Usage: <description> <amount>");
            return;
        }

        String description = args[0];
        int amount = Integer.parseInt(args[1]);
        Order orderReq = new Order(description, amount);
        Order order = orderApi.createOrder(orderReq);
        System.out.println("Order created: " + order);
    }

}
