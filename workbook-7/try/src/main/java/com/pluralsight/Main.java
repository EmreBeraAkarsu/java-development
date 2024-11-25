package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            LocalDateTime dateTime = LocalDateTime.now();

            System.out.println(dateTime.getHour());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
