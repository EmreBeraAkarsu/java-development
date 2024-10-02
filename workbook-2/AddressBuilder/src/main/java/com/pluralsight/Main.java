package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder fullName = new StringBuilder();
        StringBuilder billingAddress = new StringBuilder();
        StringBuilder shippingAddress = new StringBuilder();


        System.out.println("Please enter your full name: ");
        fullName.append(scanner.nextLine()).append("\n\n");

        System.out.println("Enter your Billing Street: ");
        billingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your Billing City: ");
        billingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your Billing State: ");
        billingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your shipping Zip: ");
        billingAddress.append(scanner.nextLine()).append("\n\n");

        System.out.println("Enter your shipping Street: ");
        shippingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your shipping City: ");
        shippingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your shipping State: ");
        shippingAddress.append(scanner.nextLine()).append("\n");

        System.out.println("Enter your shipping Zip: ");
        shippingAddress.append(scanner.nextLine());


        System.out.println(fullName + "Billing Address:\n" + billingAddress + "Shipping Address:\n" + shippingAddress);

    }
}
