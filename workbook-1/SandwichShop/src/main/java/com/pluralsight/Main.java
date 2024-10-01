package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        float itemPrice = 0.0f;
        float resultPrice = 0.0f;
        String option;
        int age;

        System.out.println("Please enter 1 for small, 2 for large");
        option = input.nextLine();

        System.out.println("Enter your age");
        age = input.nextInt();

        itemPrice = DetermineSizePrice(option);

        if (age <= 17) {
            resultPrice = YoungPrice(itemPrice);
        } else if (age >= 65) {
            resultPrice = ElderPrice(itemPrice);
        } else {
            resultPrice = itemPrice;
        }

        Display(resultPrice);

        input.close();
    }


    public static float YoungPrice(float itemPrice) {

        return ((itemPrice / 100) * 90);
    }

    public static float ElderPrice(float itemPrice) {

        return ((itemPrice / 100) * 80);
    }

    public static void Display(float resultPrice) {

        System.out.println(String.format("Your total price is: %.2f", resultPrice));
    }

    public static float DetermineSizePrice(String option) {

        float itemPrice = 0.0f;

        if (option.equals("1")) {
            itemPrice = 5.45f;
        } else if (option.equals("2")) {
            itemPrice = 8.95f;
        } else {
            System.out.println("Entered the wrong option");
        }

        return itemPrice;
    }
}
