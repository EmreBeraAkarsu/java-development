package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println("Please enter your name: ");
        String name = input.nextLine().trim();

        System.out.println("What date will you be coming? (MM/dd/yyy): ");
        LocalDate date = LocalDate.parse(input.nextLine(), formatter);

        System.out.println("How many tickets would you like? ");
        int tickets = input.nextInt();

        String firstName = (name.substring(0, name.indexOf(" ")).trim());
        String lastName = (name.substring(name.indexOf(" ")).trim());

        if (tickets > 1) {
            System.out.println(tickets + " tickets reserved for " + date + " under " + lastName + ", " + firstName);

        } else if (tickets == 1) {
            System.out.println(tickets + " ticket reserved for " + date + " under " + lastName + ", " + firstName);

        } else {
            System.out.println("Wrong number of tickets selected");
        }
    }
}
