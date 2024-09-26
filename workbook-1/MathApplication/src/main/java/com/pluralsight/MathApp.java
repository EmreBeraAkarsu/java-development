package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {

        double bobSalary = 3435.55;
        double garySalary = 3424.66;

        System.out.println("Highest Salary is: " + Math.max(bobSalary, garySalary));


        double carPrice = 46766.66;
        double truckPrice = 85685.88;

        System.out.println("Least expensive vehicle: " + Math.min(carPrice, truckPrice));


        System.out.println("Area of circle with the radius=7.25; " + (Math.pow(7.25, 2) * 3.14));


        double num1 = 67;

        System.out.println("Square root of " + num1 + ": " + Math.sqrt(num1));


        System.out.println("Distance between (5, 10) and (85, 50): " + Math.sqrt(Math.pow((5-85), 2) + Math.pow((10-50), 2)));


        float num2 = -3.8f;

        System.out.println("Absolute value of " + num2 + ": " + Math.abs(num2));


        System.out.println("A random number between 0 and 1 " + Math.random());

    }
}
