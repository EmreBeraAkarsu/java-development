package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        List<Person> people = createAListOfPeople();

        Scanner scanner = new Scanner(System.in);



        searchPersonByName(scanner);

        calculateAverageAge();

        findOldest();

        findYoungest();


    }


    public static List<Person> createAListOfPeople() {

        List <Person>people = new ArrayList<>();

        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Jane", "Smith", 30));
        people.add(new Person("Alex", "Johnson", 45));
        people.add(new Person("Emily", "Brown", 20));
        people.add(new Person("Chris", "Davis", 35));
        people.add(new Person("Olivia", "Miller", 28));
        people.add(new Person("Michael", "Wilson", 40));
        people.add(new Person("Sophia", "Moore", 22));
        people.add(new Person("David", "Taylor", 50));
        people.add(new Person("Lily", "Anderson", 27));

        return people;

    }

    public static void searchPersonByName(Scanner scanner) {

        System.out.println("Enter LAST to search by last name, FIRST to search by first name");
        String searchOption = scanner.nextLine();

        if (searchOption.equalsIgnoreCase("last")) {
            searchByLastName(scanner);
        } else if (searchOption.equalsIgnoreCase("first")) {
            searchByFirstName(scanner);
        } else {
            System.err.println("Incorrect search option!");
        }
    }

    public static void searchByLastName(Scanner scanner) {
        List<Person> filteredLastName = new ArrayList<>();

        System.out.println("Enter the last name to search for: ");
        String lastName = scanner.nextLine();

        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                filteredLastName.add(person);
            }
        }

        for (Person person : filteredLastName) {
            System.out.println(person);
        }
    }

    public static void searchByFirstName(Scanner scanner) {
        List<Person> filteredFirstName = new ArrayList<>();

        System.out.println("Enter the last name to search for: ");
        String firstName = scanner.nextLine();

        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(firstName)) {
                filteredFirstName.add(person);
            }
        }

        for (Person person : filteredFirstName) {
            System.out.println(person);
        }
    }


    public static void calculateAverageAge() {

        double totalAge = 0;

        for (Person person : people) {
            totalAge += person.getAge();
        }
        double averageAge = totalAge / people.size();

        System.out.println("Average age is " + averageAge);
    }


    public static void findOldest() {

        int oldestAge = 0;

        for (Person person : people) {
            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }
        }
        System.out.println("Oldest age is: " + oldestAge);
    }

    public static void findYoungest() {

        int youngestAge = 999999999;

        for (Person person : people) {
            if (person.getAge() < youngestAge) {

                youngestAge = person.getAge();
            }
        }
        System.out.println("Youngest age is: " + youngestAge);
    }
}
