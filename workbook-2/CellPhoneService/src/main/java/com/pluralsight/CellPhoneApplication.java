package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone phone1 = new CellPhone();

        Scanner input = new Scanner(System.in);

        System.out.println("What is the serial number?");
        phone1.setSerialNumber(input.nextInt());
        input.nextLine();

        System.out.println("What model is the phone?");
        phone1.setModel(input.nextLine());

        System.out.println("Who is the carrier?");
        phone1.setCarrier(input.nextLine());

        System.out.println("What is the phone number?");
        phone1.setPhoneNumber(input.nextLine());

        System.out.println("Who is the owner of the phone?");
        phone1.setOwner(input.nextLine());

        System.out.println("Serial Number: " + phone1.getSerialNumber() + "\nModel: " + phone1.getModel() + "\nCarrier: " + phone1.getCarrier() +
                "\nPhone Number: " + phone1.getPhoneNumber() + "\nOwner: " + phone1.getOwner());

    }
}
