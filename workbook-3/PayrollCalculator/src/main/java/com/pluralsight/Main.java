package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            int i = 0;

            while ((input = bufferedReader.readLine()) != null) {

                String[] strArray = input.split("\\|");
                //String employeeObjectNum = "employee" + i;
                Employee employeeObject = new Employee(Integer.parseInt(strArray[0]), strArray[1], Double.parseDouble(strArray[2]), Double.parseDouble(strArray[3]));

                System.out.printf("\nId: " + employeeObject.getEmployeeId() + "\nName: " + employeeObject.getName() + "\nGross Pay: " + "%.2f%n\n", employeeObject.getGrossPay());
            }
        } catch (IOException e) {
            System.out.println("Incorrect file name!");
        }


    }
}
