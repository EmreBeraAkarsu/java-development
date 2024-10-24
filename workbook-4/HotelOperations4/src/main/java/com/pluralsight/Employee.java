package com.pluralsight;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalDateTime startTimeLocalDateTime;
    private double startTime;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void punchIn(double time) {
        startTime = time;
    }

    public double getStartTime() {
        return startTime;
    }

    public void punchOut(double time) {
        double duration = time - startTime;
        hoursWorked += duration;
        startTime = 0;
    }

    public void punchIn() {
        startTimeLocalDateTime = LocalDateTime.now();
    }

    public void punchOut() {
        double durationHours;
        durationHours = startTimeLocalDateTime.until(LocalDateTime.now(), ChronoUnit.HOURS);
        hoursWorked += durationHours;

        double durationMinutes;
        durationMinutes = startTimeLocalDateTime.until(LocalDateTime.now(), ChronoUnit.MINUTES);
        hoursWorked += (durationMinutes/60);
        startTimeLocalDateTime = null;
    }

    public void punchTimeCard(double time) {
        if (startTime == 0) {
            startTime = time;
        } else {
            double duration = time - startTime;
            hoursWorked += duration;
            startTime = 0;
        }
    }

    public double getTotalPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            return (40 * payRate) + ((hoursWorked - 40) * (payRate * 1.5));
        }
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }
}