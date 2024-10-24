package com.pluralsight;

public class StaticClasses {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        String prefix = "Dr.";
        String suffix = "PhD";
        String middleName = "K";

        String fullName = prefix + " " + firstName + " " + middleName + " " + lastName + ", " + suffix;

        System.out.println(NameFormatter.format(fullName));

        System.out.println(NameFormatter.format(firstName, lastName));

        System.out.println(NameFormatter.format(prefix, firstName, middleName, lastName, suffix));
    }
}
