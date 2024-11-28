package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;
import java.util.ArrayList;

public class ProductApp {

    public static void main(String[] args) {
        
        // Get SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        // Open a new session
        try (Session session = sessionFactory.openSession()) {
            // Begin a transaction
            Transaction transaction = session.beginTransaction();
            
            // Create multiple product objects
            List<Product> products = new ArrayList<>();
           // products.add(new Product(1, "Laptop", 899.99));
            products.add(new Product(2, "Smartphone", 499.99));
            products.add(new Product(3, "Tablet", 299.99));
            products.add(new Product(4, "Smartwatch", 199.99));

            // Loop through the list of products and save each product
            for (Product product : products) {
                session.save(product);
            }
            
            // Commit the transaction
            transaction.commit();
            System.out.println("Products saved successfully!");

            // Optionally, fetch and display products to verify
            for (Product product : products) {
                Product fetchedProduct = session.get(Product.class, product.getId());
                System.out.println("Fetched Product: " + fetchedProduct.getName() + " - " + fetchedProduct.getPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown Hibernate session factory
            HibernateUtil.shutdown();
        }
    }
}
