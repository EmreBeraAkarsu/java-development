package com.pluralsight;

public class Room {


    private int numberOfBeds;
    private double getPrice;
    private boolean isOccupied;
    private boolean isDirty;


    public Room(int numberOfBeds, double getPrice, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.getPrice = getPrice;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }


    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable() {
        if (!isDirty && !isOccupied){
            return true;
        }else {
            return false;
        }
    }

}
