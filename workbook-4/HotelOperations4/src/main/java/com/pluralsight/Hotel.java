package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        boolean success = false;

        if (isSuite){
            if ((numberOfSuites - numberOfRooms) >= 0){
                success = true;
                bookedSuites +=numberOfRooms;
            }else {
                System.out.println("Not enough available suites!");
            }
        } else {
            if ((this.numberOfRooms - numberOfRooms) >= 0){
                success = true;
                bookedBasicRooms += numberOfRooms;
            } else {
                System.out.println("Not enough available rooms!");
            }
        }
        return success;
    }

    public int getAvailableSuites(){

        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms(){

        return numberOfRooms - bookedBasicRooms;
    }
}
