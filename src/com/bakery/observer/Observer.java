package com.bakery.observer;

import com.bakery.order.Order;

public interface Observer {
    void update(Order order);
}
