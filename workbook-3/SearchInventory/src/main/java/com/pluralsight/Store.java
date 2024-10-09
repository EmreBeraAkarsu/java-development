package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Store {

    private static String filename = "inventory.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {

            System.out.println("\nWhat do you want to do?\n" + "1- List all products\n" + "2- Lookup a product by its id\n" + "3- Find all products within a price range\n" + "4- Add a new product\n" + "5- Quit the application\n" + "Enter command:");
            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {

                case 1:
                    listAllProducts();
                    break;

                case 2:
                    lookupById();
                    break;
                case 3:
                    productsInPriceRange();
                    break;
                case 4:
                    addNewProduct();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Entered a wrong option");
            }
        }


    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
// this method loads product objects into inventory
// and its details are not shown

        /*inventory.add(new Product(34, "hammer", 20.32));
        inventory.add(new Product(33, "car jack", 26.32));
        inventory.add(new Product(31, "screw", 29.32));
        inventory.add(new Product(37, "screwdriver", 22.32));
        inventory.add(new Product(39, "helmet", 10.00));*/


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String input;

            while ((input = bufferedReader.readLine()) != null) {

                String[] strArray = input.split("\\|");

                inventory.add(new Product(Integer.parseInt(strArray[0]), strArray[1], Double.parseDouble(strArray[2])));

            }


            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error has occurred!");
        }

        inventory.sort(Comparator.comparing(Product::getName));

        return inventory;
    }

    public static void listAllProducts() {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public static void lookupById() {
        System.out.println("Enter the product Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            if (product.getId() == id) {
                System.out.println(product.toString());
            }

        }


    }

    public static void productsInPriceRange() {
        ArrayList<Product> inventory = getInventory();

        System.out.println("Enter the min price");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the max price");
        double max = scanner.nextDouble();


        for (Product product : inventory) {
            if (product.getPrice() <= max && product.getPrice() >= min) {

                System.out.println(product.toString());
            }

        }
    }

    public static void addNewProduct(){

        System.out.println("Enter the product you want to add with the following format: \nID|Name|Price");
        String newProduct = scanner.nextLine();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));



        /*String[] strings = newProduct.split("\\|");

        Product product = new Product(Integer.parseInt(strings[0]), strings[1], Double.parseDouble(strings[2]));*/


            bufferedWriter.write(newProduct);
        } catch (IOException e) {
            System.err.println("An Error has occurred!");
        }


    }


}

