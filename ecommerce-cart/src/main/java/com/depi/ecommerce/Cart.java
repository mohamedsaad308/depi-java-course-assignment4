package com.depi.ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the items a customer wants to buy before checking out.
 * Stores items as List<Item> so it doesn't care whether each item
 * is a Shirt, a Laptop, or anything else - polymorphism again.
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * Adds up the price of every item currently in the cart.
     */
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * Tries to sell() every item in the cart.
     *  - An item that sells successfully is printed on the receipt
     *    and removed from the cart.
     *  - An item that is out of stock (sell() throws OutOfStockException)
     *    is reported as failed and stays in the cart so the customer
     *    can decide what to do with it.
     * The cart only ends up fully empty when every item sold successfully.
     */
    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to check out.");
            return;
        }

        System.out.println("\n========== RECEIPT ==========");
        List<Item> soldItems = new ArrayList<>();
        double totalPaid = 0;

        for (Item item : items) {
            try {
                item.sell();
                soldItems.add(item);
                totalPaid += item.getPrice();
                System.out.printf("SOLD   - %-20s $%.2f%n", item.getName(), item.getPrice());
            } catch (OutOfStockException e) {
                System.out.println("FAILED - " + e.getMessage() + " (kept in cart)");
            }
        }

        items.removeAll(soldItems);

        System.out.printf("------------------------------%n");
        System.out.printf("Total paid: $%.2f%n", totalPaid);
        System.out.println("==============================");

        if (items.isEmpty()) {
            System.out.println("Checkout complete. Your cart is now empty.");
        } else {
            System.out.println(items.size() + " item(s) could not be purchased and remain in your cart.");
        }
    }
}
