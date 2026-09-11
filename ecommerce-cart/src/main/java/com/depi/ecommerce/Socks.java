package com.depi.ecommerce;

public class Socks extends Clothing {

    private int pairsInPack;

    public Socks(String name, double price, int availableCopies,
                 String size, String color, int pairsInPack) {
        super(name, price, availableCopies, size, color);
        this.pairsInPack = pairsInPack;
    }

    public int getPairsInPack() {
        return pairsInPack;
    }

    public void setPairsInPack(int pairsInPack) {
        this.pairsInPack = pairsInPack;
    }

    @Override
    public String getCategory() {
        return "Clothing - Socks";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Size: %s, Color: %s, Pairs/Pack: %d",
                getSize(), getColor(), pairsInPack);
    }
}
