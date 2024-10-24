package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void format_FirstAndLastNameEntered_expectedFirstandLastNameFormat() {

        //Arrange
        String firstName = "John";
        String lastName = "Doe";

        //Action
        String formattedOutput = NameFormatter.format(firstName, lastName);


        //Assert
        assertEquals(lastName + ", " + firstName, formattedOutput);


    }

    @Test
    void format_FullName_FullNameFormattedAsExpected() {

        //Arrange
        String firstName = "John";
        String lastName = "Doe";
        String prefix = "Dr.";
        String suffix = "PhD";
        String middleName = "K";

        String fullName = prefix + " " + firstName + " " + middleName + " " + lastName + ", " + suffix;


        //Action
        String formattedOutput = NameFormatter.format(fullName);


        //Assert
        assertEquals("Doe, Dr. John K, PhD", formattedOutput);

    }

    @Test
    void format_AllVariablesProvided_AllVariablesFormattedAsExpected() {

        //Arrange
        String firstName = "John";
        String lastName = "Doe";
        String prefix = "Dr.";
        String suffix = "PhD";
        String middleName = "K";

        String fullName = prefix + " " + firstName + " " + middleName + " " + lastName + ", " + suffix;


        //Action
        String formattedOutput = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);


        //Assert
        assertEquals("Doe, Dr. John K, PhD", formattedOutput);

    }
}