package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float result = 0;

        Scanner num1Scanner = new Scanner(System.in);
        System.out.println("Enter the 1st number: ");
        float num1 = num1Scanner.nextFloat();

        Scanner num2Scanner = new Scanner(System.in);
        System.out.println("Enter the 2nd number: ");
        float num2 = num1Scanner.nextFloat();

        Scanner operationScanner = new Scanner(System.in);
        System.out.println("Enter the operation you want to do. Enter 'A' for add, 'S' for subtract, 'M' for multiply, and 'D' for divide: ");
        String operation = operationScanner.nextLine();

        switch (operation) {

            case "A":
                result = num1 + num2;
                break;

            case "S":
                result = num1 - num2;
                break;

            case "M":
                result = num1 * num2;
                break;

            case "D":
                result = num1 / num2;
                break;
        }

        System.out.println("The result of the operation is: " + result);
    }
}
