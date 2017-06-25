package com.acmewater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

    /**
    *  This is the class to create connection with SQL server . 
    */ 

public class Db {
    private String userName;
    private String password;
    private String dbms;
    private String serverName;
    private String portNumber;
    private String dbName;

    public Db() {
        this.userName = "priya";
        this.password = "password";
        this.dbms = "sqlserver";

        this.serverName = "";
        this.portNumber = "1433";
    }


    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                        this.serverName +
                        ":" + this.portNumber + "/",
                connectionProps);

        System.out.println("Connected to database");
        return conn;
    }
}
