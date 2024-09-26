package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        float totalPay = 0;

        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Enter the name of the employee: ");
        String name = nameScanner.nextLine();

        Scanner hoursScanner = new Scanner(System.in);
        System.out.println("Enter the hours worked: ");
        float hours = hoursScanner.nextFloat();

        Scanner payRateScanner = new Scanner(System.in);
        System.out.println("Enter the pay rate: ");
        float payRate = payRateScanner.nextFloat();

        if (hours > 40){
            float overtimeHours = hours - 40;

            float overPay = (payRate * 1.5f) * overtimeHours;

            totalPay = overPay + (40 * payRate);

        } else {

            totalPay = hours * payRate;
        }

        System.out.println("Hello " + name + ". Your total payment for this week is: " + totalPay);

    }
}
