package com.b2b.techpulse.adapter.driven;

import com.b2b.techpulse.application.port.persistence.OrderLogger;
import com.b2b.techpulse.domain.model.Order;

public class OrderLoggingService implements OrderLogger {

    @Override
    public void logOrder(Order order) {
        System.out.println("Logging order: " + order);
    }
}
