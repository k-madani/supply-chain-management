package main.java;

import java.util.Date;
import java.util.UUID;

public class Order {
    private String orderId;
    private Product product;
    private Supplier supplier;
    private Date orderDate;
    private int orderQuantity;

    public Order(Product product, Supplier supplier, int orderQuantity) {
        this.orderId = UUID.randomUUID().toString();
        this.product = product;
        this.supplier = supplier;
        this.orderQuantity = orderQuantity;
        this.orderDate = new Date();
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product: " + product.getName() + 
               ", Supplier: " + supplier.getName() + ", Order Date: " + orderDate +
               ", Quantity: " + orderQuantity;
    }
}