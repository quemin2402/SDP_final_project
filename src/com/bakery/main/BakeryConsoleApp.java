package com.bakery.main;

import com.bakery.factory.BakeryItemFactory;
import com.bakery.model.BakeryItem;
import com.bakery.order.Order;
import com.bakery.order.OrderItem;
import com.bakery.order.OrderProcessor;
import com.bakery.observer.BakerObserver;
import com.bakery.observer.OrderNotifier;
import com.bakery.payment.PaymentStrategy;
import com.bakery.payment.CashPayment;
import com.bakery.payment.CardPayment;

import java.util.Scanner;

public class BakeryConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        OrderProcessor orderProcessor = new OrderProcessor();

        OrderNotifier orderNotifier = OrderNotifier.getInstance();
        orderNotifier.addObserver(new BakerObserver());

        boolean ordering = true;

        while (ordering) {
            System.out.println("Menu:");
            System.out.println("1. Croissant - $2.5");
            System.out.println("2. Latte - $3.0");
            System.out.println("3. Espresso - $2.0");
            System.out.println("4. Baguette - $2.0");
            System.out.println("5. Muffin - $1.5");
            System.out.println("6. Donut - $1.0");
            System.out.println("7. Hot Chocolate - $2.5");
            System.out.println("8. Tea - $1.5");
            System.out.print("Choose an item (1-8) or 0 to finish: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
            } else {
                BakeryItem item = BakeryItemFactory.createItem(choice);
                order.addItem(new OrderItem(item));
                System.out.println(item.getName() + " added to order.");
            }
        }

        double total = order.calculateTotal();
        System.out.println("Total: $" + total);
        System.out.print("Choose payment method (1 - Cash, 2 - Card): ");
        int paymentChoice = scanner.nextInt();
        PaymentStrategy payment = paymentChoice == 1 ? new CashPayment() : new CardPayment();
        payment.pay(total);

        System.out.println("Processing order...");
        orderProcessor.processOrder(order);
        System.out.println("Order complete. Thank you!");
    }
}
