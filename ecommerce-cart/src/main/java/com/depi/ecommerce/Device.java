package com.depi.ecommerce;

/**
 * Abstract "middle layer" between Item and the concrete device
 * types (Printer, Laptop, Projector). Same idea as Clothing:
 * adds shared attributes, still leaves getCategory() abstract.
 */
public abstract class Device extends Item {

    private String brand;
    private int warrantyMonths;

    public Device(String name, double price, int availableCopies, String brand, int warrantyMonths) {
        // Constructor chaining: Item handles name/price/availableCopies.
        super(name, price, availableCopies);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }
}
