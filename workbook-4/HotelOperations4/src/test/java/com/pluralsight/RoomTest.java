package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void checkIn_AvailableCheckIn_SuccessCheckingIn() {

        //Arrange
        Room room = new Room(3,100);

        //Act
        room.checkIn();

        //Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void checkIn_DirtyRoomCheckIn_CannotCheckingInRoomIsNotOccupied() {

        //Arrange
        Room room = new Room(3,100);
        room.setDirty(true);


        //Act
        room.checkIn();

        //Assert
        assertFalse(room.isOccupied());
    }


    @org.junit.jupiter.api.Test
    void checkIn_OccupiedRoomCheckIn_CannotCheckingInRoomIsClean() {

        //Arrange
        Room room = new Room(3,100);
        room.setOccupied(true);


        //Act
        room.checkIn();

        //Assert
        assertFalse(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void checkout_regularCheckOut_roomIsNotOccupied() {

        //Arrange
        Room room = new Room(4,120);
        room.setOccupied(true);

        //Act
        room.checkout();

        //Assert
        assertFalse(room.isOccupied());

    }

    @org.junit.jupiter.api.Test
    void cleanRoom_cleanUnoccupiedDirtyRoom_roomIsNotDirty() {

        //Arrange
        Room room = new Room(4,120);
        room.setDirty(true);

        //Act
        room.cleanRoom();

        //Assert
        assertFalse(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void cleanRoom_cleanOccupiedRoom_roomIsDirty() {

        //Arrange
        Room room = new Room(4,120);
        room.setDirty(true);
        room.setOccupied(true);

        //Act
        room.cleanRoom();

        //Assert
        assertTrue(room.isDirty());
    }


}