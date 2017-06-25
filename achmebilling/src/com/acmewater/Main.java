package com.acmewater;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String reportMonth = "";
        if (args.length != 1) {
            System.out.println("Enter the billing month format {mm-yyyy}");
            System.exit(1);
        } else {
            reportMonth = args[0];
        }
        CustomerBillingMachine customerBillingMachine = new CustomerBillingMachine(reportMonth);
        customerBillingMachine.billCustomers();
    }
}
