package com.pluralsight.models;

public class SearchByCategory {

    private double totalPrice;

    public SearchByCategory(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
