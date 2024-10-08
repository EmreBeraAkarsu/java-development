package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file employee file to process: ");
        String readingFile = scanner.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String writingFile = scanner.nextLine();

        System.out.println("How many employees will you enter in the new file: ");
        int employeeNum = scanner.nextInt();
        scanner.nextLine();

        try {
            FileReader fileReader = new FileReader(readingFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(writingFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String input;


            while ((input = bufferedReader.readLine()) != null) {

                String[] strArray = input.split("\\|");

                Employee employeeObject = new Employee(Integer.parseInt(strArray[0]), strArray[1], Double.parseDouble(strArray[2]), Double.parseDouble(strArray[3]));

                System.out.printf("\nId: " + employeeObject.getEmployeeId() + "\nName: " + employeeObject.getName() + "\nGross Pay: " + "%.2f%n\n", employeeObject.getGrossPay());


            }
            bufferedReader.close();
            fileReader.close();

            System.out.println("Enter the employee info in the following format: \nid|name|gross pay");

            bufferedWriter.write("[");

            for (int i = 0; i < employeeNum; i++) {
                System.out.println("Enter the employee information: ");
                String[] jsonEmployee = scanner.nextLine().split("\\|");
                bufferedWriter.write("\n   { \"id\": " + jsonEmployee[0].toString() + ", \"name\" : \"" + jsonEmployee[1].toString() + "\", \"grossPay\" : " + jsonEmployee[2] + " }");


                if (i != employeeNum - 1) {
                    bufferedWriter.write(",");
                }
            }

            bufferedWriter.write("\n]");

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Incorrect file name!");
        }


    }
}
