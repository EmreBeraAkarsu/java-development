package com.pluralsight;

public class Employee {

    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;


    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay(){

        return getOvertimePay() + getRegularPay();
    }

    public double getRegularHours(){

        if (hoursWorked > 40 ){

            return 40;
        }else {
            return hoursWorked;
        }

    }
    public double getOvertimeHours(){

        if (hoursWorked > 40 ){

            return hoursWorked - 40;
        }else {
            return 0;
        }

    }

    public double getOvertimePay(){
        return getOvertimeHours() * (getPayRate() * 1.5);
    }

    public double getRegularPay(){

        return getRegularHours() * payRate;
    }

}