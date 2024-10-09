package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Today is: " + now);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDateTime = now.format(fmt);
        System.out.println(formattedDateTime);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDateTime = now.format(fmt1);
        System.out.println(formattedDateTime);

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        formattedDateTime = now.format(fmt2);
        System.out.println(formattedDateTime);


        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("GMT"));

        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  hh:mm");
        formattedDateTime = zonedDateTime.format(fmt4);
        System.out.println(formattedDateTime);


        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("hh:mm");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        formattedDateTime = now.format(fmt3);
        String formattedDate = now.format(fmt5);
        System.out.println(formattedDateTime + " on " + formattedDate);


    }
}
