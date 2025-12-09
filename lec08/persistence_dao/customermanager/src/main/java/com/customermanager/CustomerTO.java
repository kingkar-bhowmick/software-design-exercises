package com.customermanager;

public class CustomerTO {

    private int customerId;
    private String firstName;
    private String lastName;

    public CustomerTO() {
    }

    public CustomerTO(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName=%s, lastName=%s]",
                customerId, firstName, lastName);
    }
}
