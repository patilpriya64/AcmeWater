package com.acmewater;

import org.apache.commons.csv.CSVRecord;

public class Customer {
    private String uuid;
    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;

    /**
    *  This is the class for the customer . This is just plain object 
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
    public Customer(CSVRecord record) {
        this.uuid = record.get("uuid");
        this.name = record.get("name");
        this.email = record.get("email");
        this.address = record.get("address");
        this.city = record.get("city");
        this.state = record.get("state");
        this.zip = record.get("zip");
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
