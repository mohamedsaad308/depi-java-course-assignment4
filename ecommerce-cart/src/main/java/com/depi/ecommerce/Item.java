package com.depi.ecommerce;

/**
 * Abstract base class for everything the store sells.
 *
 * All fields are private (encapsulation) - the only way to read or
 * change them from outside this class is through the getters/setters
 * below. Item itself can never be instantiated directly (new Item(...)
 * is not allowed) because it's abstract and has an abstract method.
 */
public abstract class Item {

    private String name;
    private double price;
    private int availableCopies;

    public Item(String name, double price, int availableCopies) {
        this.name = name;
        this.price = price;
        this.availableCopies = availableCopies;
    }

    // ----- Getters & Setters (encapsulation) -----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    // ----- Behavior -----

    /**
     * Sells one copy of this item: reduces stock by 1.
     * If there is no stock left, it refuses the sale by throwing
     * OutOfStockException instead of letting the count go negative.
     */
    public void sell() throws OutOfStockException {
        if (availableCopies <= 0) {
            throw new OutOfStockException(name + " is out of stock.");
        }
        availableCopies--;
    }

    /**
     * Returns one copy of this item back to inventory (increases stock).
     */
    public void returnItem() {
        availableCopies++;
    }

    /**
     * Abstract method: every concrete subclass must say what
     * category it belongs to, e.g. "Clothing - Shirt" or "Device - Laptop".
     * Because it's abstract here, calling item.getCategory() on any
     * Item reference always runs the real subclass's version
     * (polymorphism).
     */
    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format("%-22s | %-20s | $%8.2f | Stock: %d",
                name, getCategory(), price, availableCopies);
    }
}
