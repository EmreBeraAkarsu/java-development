package com.pluralsight;

public class Cash extends Asset{
    private double numberOfTimesStashedTheCash;

    public Cash(String description, String dateAcquired, double originalCost, double numberOfTimesStashedTheCash) {
        super(description, dateAcquired, originalCost);
        this.numberOfTimesStashedTheCash = numberOfTimesStashedTheCash;
    }

    public double getNumberOfTimesStashedTheCash() {
        return numberOfTimesStashedTheCash;
    }

    public void setNumberOfTimesStashedTheCash(double numberOfTimesStashedTheCash) {
        this.numberOfTimesStashedTheCash = numberOfTimesStashedTheCash;
    }

    @Override
    public double getValue() {
        return getOriginalCost();
    }
}
