package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplyChainManager {
    private List<Product> products = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    // Method to add a new product
    public void addProduct(String name, String description, int quantity, double price) {
        Product product = new Product(name, description, quantity, price);
        products.add(product);
        System.out.println("Product added: " + product);
    }

    // Method to add a new supplier
    public void addSupplier(String name, String contact) {
        Supplier supplier = new Supplier(name, contact);
        suppliers.add(supplier);
        System.out.println("Supplier added: " + supplier);
    }

    // Method to place an order
    public void placeOrder(String productName, String supplierName, int quantity) {
        Product product = findProductByName(productName);
        Supplier supplier = findSupplierByName(supplierName);

        if (product != null && supplier != null) {
            if (product.getQuantity() >= quantity) {
                Order order = new Order(product, supplier, quantity);
                orders.add(order);

                // Reduce product quantity after placing the order
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Order placed successfully: " + order);
            } else {
                System.out.println("Insufficient product quantity.");
            }
        } else {
            System.out.println("Invalid product or supplier.");
        }
    }

    // Helper method to find a product by name
    private Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Helper method to find a supplier by name
    private Supplier findSupplierByName(String name) {
        for (Supplier supplier : suppliers) {
            if (supplier.getName().equalsIgnoreCase(name)) {
                return supplier;
            }
        }
        return null;
    }

    // Method to display all orders
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // Method to display all suppliers
    public void displaySuppliers() {
        if (suppliers.isEmpty()) {
            System.out.println("No suppliers available.");
        } else {
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        }
    }

    public void demo () {
        SupplyChainManager manager = new SupplyChainManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSupply Chain Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Add Supplier");
            System.out.println("3. Place Order");
            System.out.println("4. Display Products");
            System.out.println("5. Display Suppliers");
            System.out.println("6. Display Orders");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(productName, description, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter supplier name: ");
                    String supplierName = scanner.nextLine();
                    System.out.print("Enter supplier contact: ");
                    String contact = scanner.nextLine();
                    manager.addSupplier(supplierName, contact);
                    break;
                case 3:
                    System.out.print("Enter product name for the order: ");
                    String orderProductName = scanner.nextLine();
                    System.out.print("Enter supplier name for the order: ");
                    String orderSupplierName = scanner.nextLine();
                    System.out.print("Enter order quantity: ");
                    int orderQuantity = scanner.nextInt();
                    manager.placeOrder(orderProductName, orderSupplierName, orderQuantity);
                    break;
                case 4:
                    manager.displayProducts();
                    break;
                case 5:
                    manager.displaySuppliers();
                    break;
                case 6:
                    manager.displayOrders();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}