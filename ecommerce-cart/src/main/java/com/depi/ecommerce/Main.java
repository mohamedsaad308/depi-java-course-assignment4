package com.depi.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console entry point. Pre-populates a store inventory, then shows a
 * menu loop so the user can browse items, manage a Cart, checkout,
 * and return items - all driven by java.util.Scanner.
 */
public class Main {

    // The full store inventory (all items the store owns).
    private static final List<Item> inventory = new ArrayList<>();

    // The customer's shopping cart.
    private static final Cart cart = new Cart();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedInventory();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> viewInventory();
                case 2 -> addItemToCart();
                case 3 -> viewCart();
                case 4 -> cart.checkout();
                case 5 -> returnItemToStock();
                case 6 -> {
                    running = false;
                    System.out.println("Thanks for shopping with us. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please choose a number from 1 to 6.");
            }
        }

        scanner.close();
    }

    /**
     * Fills the store with a handful of ready-made products so the
     * menu has something to show right from the start.
     */
    private static void seedInventory() {
        // Clothing
        inventory.add(new Shirt("Classic Tee", 15.99, 10, "M", "White", "Cotton"));
        inventory.add(new Shirt("Graphic Hoodie", 34.99, 5, "L", "Black", "Fleece"));
        inventory.add(new Socks("Ankle Socks 3-Pack", 8.50, 20, "One Size", "Gray", 3));
        inventory.add(new Hat("Baseball Cap", 12.00, 15, "One Size", "Navy", "Snapback"));

        // Devices
        inventory.add(new Printer("InkJet Pro 200", 89.99, 4, "Canon", 12, true));
        inventory.add(new Laptop("UltraBook X1", 999.99, 3, "Dell", 24, 16));
        inventory.add(new Projector("HomeView 4K", 450.00, 2, "Epson", 18, 3200));
    }

    private static void printMenu() {
        System.out.println("\n===== E-Commerce Store Menu =====");
        System.out.println("1. View Store Inventory");
        System.out.println("2. Add Item to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Return Item");
        System.out.println("6. Exit");
    }

    /**
     * Prints every item's index, stock, category (via the polymorphic
     * getCategory() call) and its own specific attributes (via each
     * subclass's overridden toString()).
     */
    private static void viewInventory() {
        System.out.println("\n--- Store Inventory ---");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("[" + i + "] " + inventory.get(i));
        }
    }

    private static void addItemToCart() {
        if (inventory.isEmpty()) {
            System.out.println("The store has no items.");
            return;
        }

        viewInventory();
        int index = readInt("Enter the item ID to add to cart: ");

        if (!isValidIndex(index)) {
            System.out.println("Invalid item ID.");
            return;
        }

        Item selected = inventory.get(index);
        if (selected.getAvailableCopies() <= 0) {
            System.out.println(selected.getName() + " is currently out of stock and cannot be added.");
            return;
        }

        cart.addItem(selected);
        System.out.println(selected.getName() + " was added to your cart.");
    }

    /**
     * Shows every item currently in the cart plus the running total.
     * Calling getCategory() here again runs each item's real subclass
     * version - same polymorphism idea as in viewInventory().
     */
    private static void viewCart() {
        System.out.println("\n--- Your Cart ---");
        List<Item> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        for (Item item : items) {
            System.out.println(item);
        }
        System.out.printf("Total: $%.2f%n", cart.calculateTotal());
    }

    private static void returnItemToStock() {
        if (inventory.isEmpty()) {
            System.out.println("The store has no items.");
            return;
        }

        viewInventory();
        int index = readInt("Enter the item ID to return to stock: ");

        if (!isValidIndex(index)) {
            System.out.println("Invalid item ID.");
            return;
        }

        Item selected = inventory.get(index);
        selected.returnItem();
        System.out.println(selected.getName() + " returned. New stock: " + selected.getAvailableCopies());
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < inventory.size();
    }

    /**
     * Reads a line from the console and keeps asking until it's a
     * valid whole number, so the menu never crashes on bad input.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
