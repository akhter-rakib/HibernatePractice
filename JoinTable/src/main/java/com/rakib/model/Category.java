/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakib.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rakib
 */
@Entity
@Table(name = "CATEGORY")
public class Category {

    private long id;
    private String name;
    private Set<Article> articles;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_ARTICLE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
    )
    public Set<Article> getArticles() {
        return articles;
    }
//    Here , we use the @JoinTable annotation to specify the details of the join table(table name
//    and two join columns - using the @JoinColumn annotation); and we set the cascade attribute of 
//    the @OneToMany annotation so that Hibernate will update  the associated articles when the category 
//    is updated And note that we don
//    ’t have to use any special annotations for the Article side , as this association is unidirectional ;
//    and there is no need to create a mapping class for the join table.

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}
