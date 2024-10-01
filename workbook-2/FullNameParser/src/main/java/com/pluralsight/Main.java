package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String firstName = "";
        String middleName = "";
        String lastName = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String fullName = scanner.nextLine();

        String[] splitNames = fullName.split(" ");

        if (splitNames.length < 2) {
            System.out.println("You need to enter a first and last name");

            return;

        } else if (splitNames.length > 3) {
            System.out.println("You can only enter 3 names");

            return;

        } else if (splitNames.length == 2) {
            firstName = splitNames[0];
            middleName = "(none)";
            lastName = splitNames[1];

        } else {
            firstName = splitNames[0];
            middleName = splitNames[1];
            lastName = splitNames[2];
        }

        System.out.println("First name: " + firstName + "\nMiddle Name: " + middleName + "\nLast Name: " + lastName);


    }
}
