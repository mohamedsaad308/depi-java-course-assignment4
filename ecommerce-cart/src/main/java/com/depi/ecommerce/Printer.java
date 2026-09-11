package com.depi.ecommerce;

public class Printer extends Device {

    private boolean isColor;

    public Printer(String name, double price, int availableCopies,
                    String brand, int warrantyMonths, boolean isColor) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.isColor = isColor;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setColor(boolean isColor) {
        this.isColor = isColor;
    }

    @Override
    public String getCategory() {
        return "Device - Printer";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Brand: %s, Warranty: %d mo, Color: %s",
                getBrand(), getWarrantyMonths(), isColor ? "Yes" : "No");
    }
}
