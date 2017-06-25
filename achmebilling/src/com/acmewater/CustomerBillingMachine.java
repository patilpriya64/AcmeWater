package com.acmewater;

import java.util.ArrayList;

public class CustomerBillingMachine {
    private String reportMonth;
    private String reportYear;

        /**
    *  this class handles billing the customer
    */ 

    public CustomerBillingMachine(String reportMonth) {
        String[] parts = reportMonth.split("-");
        this.reportMonth = parts[0];
        this.reportYear = parts[1];
    }


    private ArrayList<Customer> getBillableCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        // query the database to get all customers that have
        // not been billed for given month

        // loop over result set and add new customer objects to the
        // customers array to be returned
        // pseudo code
        // for (Result result : sqlResultSet) {
        //     Customer customer = new Customer(result.getString("uuid")...);
        //     customers.add(customer);
        // }

        return customers;
    }

    private double getAmountDue(Customer customer) {
        String targetAddress = String.format("http://api.acme.fake/due/{0}/{1}/{2}",
                customer.getUuid(), reportMonth, reportYear);

        double amountDue = 0.0;

        // make an http request to the api with the url

        // parse the api response into json object

        // extract the amount due field and convert it to double

        // return the amount
        return amountDue;

    }

    private void generateBill(Customer customer, double amountDue) {
        // generate email
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ");
        sb.append(customer.getName());
        sb.append(",\n");
        sb.append("Thank you for using Acme Water for your address at ");
        sb.append(customer.getAddress() + " " + customer.getCity() + ", "
                + customer.getState() + " " + customer.getZip());
        sb.append(". The amount due for the month of ");
        sb.append(reportMonth + "-" + reportYear);
        sb.append(" is $");
        sb.append(amountDue + ".");
        sb.append("Warm Regards, Achme Water");

        // send the email string
    }

    private void updateBilling(Customer customer, String reportMonth, String reportYear) {
        // connect to database

        // update this record in the billing table to indicate this customer has been billed

    }


    /* 
    *  this is the main method to start generating bills
    */
    public void billCustomers() {
        // get a list of customers from the database that haven't been billed in given month
        ArrayList<Customer> customers = getBillableCustomers();

        // for each customer get the amount due, the generate bill
        // update the database to indicate the customer has been billed
        for (Customer customer : customers) {
            double amountDue = getAmountDue(customer);

            // call generate bill
            generateBill(customer, amountDue);

            // call update billing
            updateBilling(customer, reportMonth, reportYear);
        }


    }




}
