package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn_RegularPunchIn_PunchInTimeIsSetAsStartTime() {

        //Arrange
        Employee employee = new Employee(2342342, "Ray", "Management", 1000);

        //Act
        double punchInTime = 1234;
        employee.punchIn(punchInTime);

        //Assert
        assertEquals(punchInTime, employee.getStartTime());
    }

    @Test
    void punchOut_RegularPunchOut_StartTimeIsZeroAndHoursWorkedUpdatedWithANewAddition() {

        //Arrange
        Employee employee = new Employee(2342342, "Ray", "Management", 1000);
        double punchInTime = 1234;
        employee.punchIn(punchInTime);
        double punchOutTime = 1255;
        double hoursWorkedExpected = punchOutTime - punchInTime;


        //Act
        employee.punchOut(punchOutTime);

        //Assert
        assertEquals(employee.getStartTime(), 0);
        assertEquals(employee.getHoursWorked(), hoursWorkedExpected);
    }
}