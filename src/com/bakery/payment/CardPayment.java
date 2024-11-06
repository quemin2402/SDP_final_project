// src/com/bakery/payment/CardPayment.java
package com.bakery.payment;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using card.");
    }
}