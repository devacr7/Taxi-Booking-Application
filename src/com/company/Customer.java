package com.company;

public class Customer {

    static int count = 1;
    private int customerId;
    private int bookingId;
    private char pickUpPoint;
    private char dropPoint;
    private int pickUpTime;
    private int dropTime;
    private int amount;
    private int taxiAllocated;

    public Customer(char pickUpPoint, char dropPoint, int pickUpTime) {
        this.customerId = count++;
        this.bookingId = count;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
        this.pickUpTime = pickUpTime;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTaxiAllocated() {
        return taxiAllocated;
    }

    public void setTaxiAllocated(int taxiAllocated) {
        this.taxiAllocated = taxiAllocated;
    }
}
