package com.rakib.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.rakib.model.Category;
import com.rakib.model.Product;
import com.rakib.util.NewHibernateUtil;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.login.Configuration;
import org.hibernate.Session;

/**
 *
 * @author Rakib
 */
public class StockManager {

    public static void main(String[] args) {
        
        //Run this class only 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Category category = new Category("Computer");
        Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
        category.setProducts(products);
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }
}
