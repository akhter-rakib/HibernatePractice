/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.Controller;

import com.rakib.model.Article;
import com.rakib.model.Category;
import com.rakib.util.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Rakib
 */
public class ArticlesManager {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Category category = new Category("Hibernate Framework");
        Article articleOne = new Article("One-to-One Mapping",
                "One-to-One XML Mapping Tutorial", "Hibernate,One-to-One",
                "Content of One-to-One XML Mapping Tutorial");
        Article articleTwo = new Article("One-to-Many Mapping",
                "One-to-Many XML Mapping Tutorial", "Hibernate,One-to-Many",
                "Content of One-to-Many XML Mapping Tutorial");
        Article articleThree = new Article("Many-to-Many Mapping",
                "Many-to-Many XML Mapping Tutorial", "Hibernate,Many-to-Many",
                "Content of Many-to-Many XML Mapping Tutorial");

        Set<Article> articles = new HashSet<Article>();
        articles.add(articleOne);
        articles.add(articleTwo);
        articles.add(articleThree);
        category.setArticles(articles);
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }
}
