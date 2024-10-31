package com.pluralsight.finance;

public class Jewelery extends FixedAsset{

    private double karat;

    public Jewelery(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }


    @Override
    public double getValue() {
        return 0;
    }
}
