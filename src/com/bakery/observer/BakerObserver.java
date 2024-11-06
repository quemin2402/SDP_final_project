package com.bakery.observer;

import com.bakery.order.Order;

public class BakerObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("Baker notification: Order is ready - \n" + order);
    }
}
