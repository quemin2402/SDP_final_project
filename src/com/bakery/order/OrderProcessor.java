// src/com/bakery/order/OrderProcessor.java
package com.bakery.order;

import com.bakery.model.BakeryItem;
import com.bakery.observer.OrderNotifier;

public class OrderProcessor {

    public void processOrder(Order order) {
        for (OrderItem orderItem : order.getItems()) {
            BakeryItem item = orderItem.getItem();
            System.out.println("Preparing " + item.getName() + " (" + item.getPreparationTime() + " min)...");
        }

        // Уведомляем всех наблюдателей о завершении заказа
        OrderNotifier.getInstance().notifyObservers(order);
    }
}
