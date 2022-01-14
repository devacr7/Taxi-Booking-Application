package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        Booking.loadInitialDetails();
        System.out.println("Welcome to Taxi Booking System");
        int choice;
        do {
            Booking booking = new Booking();
            System.out.println("Press\n1. Call Taxi Booking\n2. Display all taxi details\n3. Stop the Application");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the pickup point : ");
                    char pickUpPoint = sc.next().charAt(0);
                    pickUpPoint = String.valueOf(pickUpPoint).toUpperCase().charAt(0);
                    if(pickUpPoint < 'A' || pickUpPoint > 'F'){
                        System.out.println("Pickup point is invalid");
                        break;
                    }
                    System.out.println("Enter the drop point : ");
                    char dropPoint = sc.next().charAt(0);
                    dropPoint = String.valueOf(dropPoint).toUpperCase().charAt(0);
                    if(dropPoint < 'A' || dropPoint > 'F'){
                        System.out.println("drop point  is invalid");
                        break;
                    }
                    System.out.println("Enter the pickup time : ");
                    int pickUpTime = sc.nextInt();
                    Customer customer = new Customer(pickUpPoint, dropPoint, pickUpTime);
                    booking.bookTaxi(customer);
                    break;
                case 2:
                    booking.printAllDetails();
            }
        }while(choice != 3);
    }
}
