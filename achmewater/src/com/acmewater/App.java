package com.acmewater;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
	// write your code here
        String filePath;
        if (args.length != 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path to the csv file");
            filePath = scanner.nextLine();
        } else {
            filePath = args[0];
        }

        CustomerReader customerReader = new CustomerReader();
        customerReader.processCSV(filePath);
    }
}
