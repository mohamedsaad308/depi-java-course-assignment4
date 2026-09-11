package com.depi.ecommerce;

public class Laptop extends Device {

    private int ramGB;

    public Laptop(String name, double price, int availableCopies,
                  String brand, int warrantyMonths, int ramGB) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.ramGB = ramGB;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    @Override
    public String getCategory() {
        return "Device - Laptop";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Brand: %s, Warranty: %d mo, RAM: %dGB",
                getBrand(), getWarrantyMonths(), ramGB);
    }
}
