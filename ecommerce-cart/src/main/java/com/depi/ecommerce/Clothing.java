package com.depi.ecommerce;

/**
 * Abstract "middle layer" between Item and the concrete clothing
 * types (Shirt, Socks, Hat). It adds attributes common to all
 * clothing but still doesn't implement getCategory() itself -
 * that's left to the concrete subclasses, so Clothing stays abstract.
 */
public abstract class Clothing extends Item {

    private String size;
    private String color;

    public Clothing(String name, double price, int availableCopies, String size, String color) {
        // Constructor chaining: Item handles name/price/availableCopies.
        super(name, price, availableCopies);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
