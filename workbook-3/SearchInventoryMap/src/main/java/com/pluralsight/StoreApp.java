package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StoreApp {
    // the key is the product id, the value is a product object
//    static HashMap<Integer, Product> inventory =
//            new HashMap<Integer, Product>();

    static HashMap<String, Product> nameKeyInventory = new HashMap<>();
    private static String fileName = "inventory.csv";

    public static void main(String[] args) {
// this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("What item name are you interested in? ");
            String name = scanner.nextLine();
            Product matchedProduct = nameKeyInventory.get(name);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                continue;
            }
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());

            System.out.println("\nEnter Y to search again, N to stop");
            String searchAgain = scanner.nextLine();

            if (searchAgain.equalsIgnoreCase("y")) {
                continue;
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    public static void loadInventory() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String input;

            while ((input = bufferedReader.readLine()) != null) {

                String[] strings = input.split("\\|");

                nameKeyInventory.put(strings[1], new Product(Integer.parseInt(strings[0]), strings[1], Double.parseDouble(strings[2])));
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Error occurred!");
        }
    }
}

