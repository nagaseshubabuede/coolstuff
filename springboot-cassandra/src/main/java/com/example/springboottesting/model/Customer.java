package com.example.springboottesting.model;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String fName;
    private String lName;

    private String fullName;

    public Customer() {}

    public Customer(UUID id, String fName, String lName, String fullName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
