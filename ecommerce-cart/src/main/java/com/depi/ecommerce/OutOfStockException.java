package com.depi.ecommerce;

/**
 * Thrown when someone tries to sell() an Item that has zero
 * availableCopies left. It's a "checked" exception (extends Exception,
 * not RuntimeException) so the compiler forces every caller of sell()
 * to either catch it or declare it - this makes the "out of stock"
 * case impossible to forget about.
 */
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
