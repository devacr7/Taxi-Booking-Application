package com.company;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int name;
    private int totalAmount = 0;
    private List<Customer> customerBookingList;

    public Taxi(int name) {
        this.name = name;
        this.customerBookingList = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public void setName(int Name) {
        this.name = name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount += totalAmount;
    }

    public List<Customer> getCustomerBookingList() {
        return customerBookingList;
    }

    public void setCustomerBookingList(Customer customer) {
        this.customerBookingList.add(customer);
    }

}
