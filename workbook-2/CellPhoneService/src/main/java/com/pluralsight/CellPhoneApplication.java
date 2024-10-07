package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone phone1 = new CellPhone();
        CellPhone phone2 = new CellPhone();
        CellPhone phone3 = new CellPhone(123123, "Iphone X", "Verizon", "777-444-3322", "Emre Akarsu");

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





        System.out.println("What is the serial number of the second phone?");
        phone2.setSerialNumber(input.nextInt());
        input.nextLine();

        System.out.println("What model is the of the second phone?");
        phone2.setModel(input.nextLine());

        System.out.println("Who is the carrier of the second phone?");
        phone2.setCarrier(input.nextLine());

        System.out.println("What is the phone number of the second phone?");
        phone2.setPhoneNumber(input.nextLine());

        System.out.println("Who is the owner of the phone of the second phone?\n");
        phone2.setOwner(input.nextLine());


        phone1.dial("855-555-2222");

        display(phone1);
        display(phone2);
        display(phone3);

        phone1.dial(phone2.getPhoneNumber());
        phone2.dial(phone1.getPhoneNumber());

    }

    public static void display(CellPhone cellPhone){
        System.out.println("Serial Number: " + cellPhone.getSerialNumber() + "\nModel: " + cellPhone.getModel() + "\nCarrier: " + cellPhone.getCarrier() +
                "\nPhone Number: " + cellPhone.getPhoneNumber() + "\nOwner: " + cellPhone.getOwner());

    }
}
