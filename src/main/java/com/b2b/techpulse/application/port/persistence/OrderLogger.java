package com.b2b.techpulse.application.port.persistence;

import com.b2b.techpulse.domain.model.Order;

public interface OrderLogger {
    void logOrder(Order order);
}
