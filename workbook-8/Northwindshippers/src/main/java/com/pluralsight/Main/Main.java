package com.pluralsight.Main;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");

        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the company name: ");
        String companyName = scanner.nextLine();

        System.out.println("Enter the phone:");
        String phone = scanner.nextLine();

        dataManager.insertIntoWithGeneratedKeys(companyName, phone);

        List<Shipper> shippers = dataManager.getAllShippers();

        for (Shipper shipper : shippers) {
            System.out.println(shipper);

        }

        System.out.println("Enter the id of a shipper to change its phone:");
        int idOfAShipperToUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the phone to update:");
        String phoneToUpdate = scanner.nextLine();

        dataManager.updateRecord(idOfAShipperToUpdate, phoneToUpdate);

        shippers = dataManager.getAllShippers();

        for (Shipper shipper : shippers) {
            System.out.println(shipper);

        }

        System.out.println("Enter the id of a shipper to delete:");
        int shipperIDToDelete = scanner.nextInt();
        scanner.nextLine();

        dataManager.deleteRecord(shipperIDToDelete);

        shippers = dataManager.getAllShippers();

        for (Shipper shipper : shippers) {
            System.out.println(shipper);

        }
    }
}
