package com.acmewater;

public class Customer {
    private String uuid;
    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;


    /**
    *  This is the customer class plain old Java object
    */ 
    public Customer(String uuid, String name, String email, String address, String city, String state, String zip) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String toString() {
        return "UUID: " +   this.uuid
                + " name: " + this.name
                + " email: " + this.email
                + " address: " + this.address
                + " city: " + this.city
                + " state: " + this.state
                + " zip " + this.zip;
    }
}
