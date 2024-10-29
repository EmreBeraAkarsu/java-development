package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();

        House house1 = new House("My regular house", "09-08-2001", 100000, "123 Main Ave.", 1, 2400000, 3000);
        House house2 = new House("My summer house", "08-08-2000", 200000, "234 Main ave", 2, 200000, 10000);

        Vehicle vehicle1 = new Vehicle("My ride", "05-04-2023", 243424, "Bugatti", 2023, 10000);
        Vehicle vehicle2 = new Vehicle("Other ride", "04-05-2020", 434243, "Toyota", 2020, 200000);

        for (Asset asset : assets) {

            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            

            if (asset instanceof Vehicle){
                System.out.println();
            }

        }
    }
}
