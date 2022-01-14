package com.company;

import java.util.*;

public class Booking {

    static List<Character> currentLocation = new ArrayList<>();
    static Map<Integer, Taxi> taxiObjMap = new HashMap<>();

    public void bookTaxi(Customer customer) {
        char pickUp = customer.getPickUpPoint();
        char drop = customer.getDropPoint();
        customer.setDropTime(Math.abs((int)pickUp - (int)drop) + customer.getPickUpTime());
        int pickUpTime = customer.getPickUpTime();
        int dropTime = customer.getDropTime();

        int i = 1, taxi = -1, diff = Integer.MAX_VALUE;
        for(Character c : currentLocation) {
            if(isCurrentTaxiFree(i, pickUpTime, dropTime, pickUp)) {
                if (Math.abs((int) pickUp - (int) c) < diff) {
                    diff = Math.abs((int) pickUp - (int) c);
                    taxi = i;
                } else if (Math.abs((int) pickUp - (int) c) == diff) {
                    if (taxiObjMap.get(i).getTotalAmount() < taxiObjMap.get(taxi).getTotalAmount()) {
                        diff = Math.abs((int) pickUp - (int) c);
                        taxi = i;
                    }
                }
            }
            i++;
        }
        if(taxi == -1) {
            System.out.println("No taxi is free at the moment. Sorry, Your booking is rejected!!");
            System.out.println("current location : "+currentLocation);
            return;
        }
        currentLocation.set(taxi-1, drop);
        System.out.println("Taxi "+taxi+" is allocated");
        int cost = 100 + (((Math.abs((int)pickUp - (int)drop) * 15) - 5) * 10);
        customer.setAmount(cost);
        taxiObjMap.get(taxi).setTotalAmount(cost);
        taxiObjMap.get(taxi).setCustomerBookingList(customer);
        customer.setTaxiAllocated(taxi);
        System.out.println("current location : "+currentLocation);
    }

    public void printAllDetails() {
        System.out.println("Taxi No:\t\tTotal Earnings");
        System.out.println("BookingId\tCustomerId\tFrom\tTo\tPickUpTime\tDropTime\tAmount");
        System.out.println("-------------------------------------------------------------\n");
        for(int i=1;i<=4;i++) {
            System.out.println("Taxi - "+i+":\t\tTotal Earnings "+taxiObjMap.get(i).getTotalAmount());
            for(Customer c : taxiObjMap.get(i).getCustomerBookingList()) {
                System.out.println(c.getCustomerId()+"\t\t"+c.getBookingId()+"\t\t"+c.getPickUpPoint()+"\t\t"+c.getDropPoint()+"\t\t"+c.getPickUpTime()+"\t\t"+c.getDropTime()+"\t\t"+c.getAmount());
            }
        }
    }

    public boolean isCurrentTaxiFree(int taxi, int pickUpTime, int dropTime, char pickUp) {
        List<Customer> customerBookingList = taxiObjMap.get(taxi).getCustomerBookingList();
        boolean isFree = true;
        if(customerBookingList.size() == 0 || customerBookingList.isEmpty())
            return isFree;
        for(Customer customer : customerBookingList) {
            int prevPickUpTime = customer.getPickUpTime();
            int prevDropTime = customer.getDropTime();
            int prePickUpTravel = Math.abs((int)pickUp - (int)customer.getDropPoint());
            pickUpTime -= prePickUpTravel;
            if((pickUpTime >= prevPickUpTime && pickUpTime < prevDropTime) || (dropTime > prevPickUpTime && dropTime <= prevDropTime))
                isFree = false;
        }
        return isFree;
    }

    public static void loadInitialDetails() {
        char c = 'A';
        for(int i=1;i<=4;i++) {
            currentLocation.add(c);
        }
        for(int i=1;i<=4;i++) {
            taxiObjMap.put(i, new Taxi(i));
        }
    }
}
