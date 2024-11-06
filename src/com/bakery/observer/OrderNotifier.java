package com.bakery.observer;

import java.util.ArrayList;
import java.util.List;
import com.bakery.order.Order;

public class OrderNotifier {
    private static OrderNotifier instance;
    private List<Observer> observers = new ArrayList<>();

    private OrderNotifier() {}

    public static OrderNotifier getInstance() {
        if (instance == null) {
            instance = new OrderNotifier();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Order order) {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }

}
