package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the name of the story: ");
            String storyName = input.nextLine();

            FileInputStream fis = new FileInputStream(storyName);
            Scanner scanner = new Scanner(fis);

            String output;

            int i = 1;

            while (scanner.hasNextLine()) {

                output = scanner.nextLine();
                System.out.println(i + ": " + output);

                i++;
            }

            scanner.close();
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid story name!");
        }
    }
}
