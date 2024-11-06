package com.bakery.factory;

import com.bakery.model.*;
import com.bakery.model.menu.*;

public class BakeryItemFactory {
    public static BakeryItem createItem(int itemId) {
        switch (itemId) {
            case 1:
                return new Croissant();
            case 2:
                return new Latte();
            case 3:
                return new Espresso();
            case 4:
                return new Baguette();
            case 5:
                return new Muffin();
            case 6:
                return new Donut();
            case 7:
                return new HotChocolate();
            case 8:
                return new Tea();
            default:
                throw new IllegalArgumentException("Invalid item ID.");
        }
    }
}
