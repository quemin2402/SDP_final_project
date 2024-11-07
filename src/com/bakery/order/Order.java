package com.bakery.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(item -> item.getItem().getPrice()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order contains:\n");
        for (OrderItem item : items) {
            sb.append("- ").append(item.getItem().getName())
                    .append(" (").append(item.getItem().getPreparationTime()).append(" min)\n");
        }
        return sb.toString();
    }
}
