package com.acmewater;

import org.apache.commons.csv.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

    /**
    * This classs will read csv file which will read customer data . This calss will connect to SQL Server using JDBC connection 
    * CSV parser will read the file(customerData) and will pass it to store procedure in SQL server.
    * Store procedure will update customer data if it already exist if it is a new customer then it will insert new record 
    * into customer table.
    */ 

public class CustomerReader {

    private Db db;


    public CustomerReader() {
        db = new Db();
    }


    private void sendCustomerToDatabase(Customer customer) {
//        try {
            // todo: set up a real db connection
//            Connection conn = db.getConnection();
//            CallableStatement statement = conn.prepareCall("{call insertOrUpdateCustomer(?, ?, ?, ?, ?, ?, ?)}");
//            statement.setString(1, customer.getUuid());
//            statement.setString(2, customer.getName());
//            statement.setString(3, customer.getEmail());
//            statement.setString(4, customer.getAddress());
//            statement.setString(5, customer.getCity());
//            statement.setString(6, customer.getState());
//            statement.setString(7, customer.getZip());
//
//            statement.execute();
//        } catch (SQLException e) {
//            System.out.println("Error connecting to the database");
//            e.printStackTrace();
//        }


    }

    public void processCSV(String filePath) {

        try {
            File f = new File(filePath);
            CSVParser parser = CSVParser.parse(f, Charset.defaultCharset(),CSVFormat.DEFAULT.withHeader());

            // insert or update records into the database
            for (CSVRecord record : parser) {
                Customer customer = new Customer(record);
                sendCustomerToDatabase(customer);
            }
        } catch (IOException ioe) {
            System.out.println("Could not open csv file");
        }
    }


}
