package com.depi.ecommerce;

public class Projector extends Device {

    private int lumens;

    public Projector(String name, double price, int availableCopies,
                      String brand, int warrantyMonths, int lumens) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.lumens = lumens;
    }

    public int getLumens() {
        return lumens;
    }

    public void setLumens(int lumens) {
        this.lumens = lumens;
    }

    @Override
    public String getCategory() {
        return "Device - Projector";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Brand: %s, Warranty: %d mo, Lumens: %d",
                getBrand(), getWarrantyMonths(), lumens);
    }
}
