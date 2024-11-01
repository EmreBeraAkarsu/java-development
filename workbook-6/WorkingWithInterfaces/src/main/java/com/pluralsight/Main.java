package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        Person person1 = new Person("Joe", "Smith", 34);
        Person person2 = new Person("Jane", "Smother", 34);
        Person person3 = new Person("Mike", "Sim", 34);
        Person person4 = new Person("Luke", "Kei", 34);
        Person person5 = new Person("Jason", "Kei", 34);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);


        Collections.sort(people);

        for (Person person : people) {
            System.out.println(person);

        }

    }
}
