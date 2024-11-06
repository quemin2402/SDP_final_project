// src/com/bakery/order/OrderItem.java
package com.bakery.order;

import com.bakery.model.BakeryItem;

public class OrderItem {
    private final BakeryItem item;

    public OrderItem(BakeryItem item) {
        this.item = item;
    }

    public BakeryItem getItem() {
        return item;
    }
}
