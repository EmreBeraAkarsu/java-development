package com.pluralsight.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SalesByYear {

    private LocalDateTime shippedDate;
    private int orderId;
    private double subtotal;
    private LocalDate year;

    public SalesByYear(LocalDateTime shippedDate, int orderId, double subtotal, LocalDate year) {
        this.shippedDate = shippedDate;
        this.orderId = orderId;
        this.subtotal = subtotal;
        this.year = year;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public LocalDate getYear() {
        return year;
    }
}
