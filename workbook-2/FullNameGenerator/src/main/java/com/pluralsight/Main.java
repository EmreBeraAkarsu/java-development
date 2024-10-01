package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fullName = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your middle name: ");
        String middleName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your suffix: ");
        String suffix = scanner.nextLine();

        firstName = firstName.trim();
        middleName = middleName.trim();
        lastName = lastName.trim();
        suffix = suffix.trim();


        if (firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("Please don't leave your first and last name empty!");

            return;

        } else if (middleName.isEmpty() && suffix.isEmpty()) {
            fullName = firstName + " " + lastName;

        } else if (middleName.isEmpty()) {
            fullName = firstName + " " + lastName + ", " + suffix;

        } else if (suffix.isEmpty()) {
            fullName = firstName + " " + middleName.charAt(0) + ". " + lastName;

        } else {
            fullName = firstName + " " + middleName.charAt(0) + ". " + lastName + ", " + suffix;

        }

        System.out.println("Full name: " + fullName);


    }
}
