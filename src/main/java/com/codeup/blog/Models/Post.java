package com.codeup.blog.Models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.regex.Pattern;


@Entity
@Table(name = "posts")
public class Post{

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String body;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn
    private User owner;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    public Post(String title, String body, long id){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

//    public String[] getSubtitle() {
//        return subtitle;
//    }
//
//    public void setSubtitle(String[] subtitle) {
//        this.subtitle = subtitle;
//    }
}