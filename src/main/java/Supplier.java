package main.java;

import java.util.UUID;

public class Supplier {
    private String supplierId;
    private String name;
    private String contactInfo;

    public Supplier(String name, String contactInfo) {
        this.supplierId = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Supplier ID: " + supplierId + ", Name: " + name + ", Contact Info: " + contactInfo;
    }
}