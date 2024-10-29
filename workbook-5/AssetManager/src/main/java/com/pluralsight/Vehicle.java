package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue(){

        int age = (LocalDate.now().getYear() - year);

        double cost = this.getValue();

        if (age >= 0 && age <= 3){
            cost = cost * Math.pow(.97, age);
        } else if (age >= 4 && age <= 6) {
            cost *= Math.pow(.94, age);
        } else if (age >= 7 && age <= 10) {
            cost *= Math.pow(.92, age);
        } else if (age > 10) {
            cost -= (age * 1000);

            if (!makeModel.contains("Honda") && !makeModel.contains("Toyota")){
                cost *= .75;
            }
        }else {
            System.out.println("Incorrect year of the vehicle entered!");
        }

        return cost;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                '}';
    }
}
