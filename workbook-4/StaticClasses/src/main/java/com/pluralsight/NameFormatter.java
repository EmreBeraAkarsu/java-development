package com.pluralsight;

public class NameFormatter {

    private NameFormatter(){}

    public static String format(String firstName, String lastName){

         return lastName + ", " + firstName;
    }
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){

        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }
    public static String format(String fullName){

          String prefix;
          String firstName;
          String middleName;
          String lastName;
          String suffix;


        String[] strings = fullName.split(" ");

        if (strings.length == 5){
            prefix = strings[0];
            firstName = strings[1];
            middleName = strings[2];
            lastName = strings[3].substring(0, (strings[3].length() - 1) );
            suffix = strings[4];

            return format(prefix, firstName, middleName, lastName, suffix);
        } else if (strings.length == 4) {
            firstName = strings[0];
            middleName = strings[1];
            lastName = strings[2];
            suffix = strings[3];

            return lastName + ", " + firstName + " " + middleName + ", " + suffix;

        } else if (strings.length == 2) {
            firstName = strings[0];
            lastName = strings[1];

            return format(firstName, lastName);

        } else {
            System.out.println("Invalid name entered!");
        }
            return "";

    }

}
