package com.pluralsight;

interface Movable {
    default void Move() {
        System.out.println("I am moving");
    }
}
