package com.codeup.zenithspringadlister.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {


    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 55)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Ad> ads;// SET is like a LIST but DOESN'T AlLOW Duplicates   <-----------------
                         // Sets up A RELATIONSHIP between Ad and Tags


    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, Set<Ad> ads) {
        this.name = name;
        this.ads = ads;
    }

    public Tag(long id, String name, Set<Ad> ads) {
        this.id = id;
        this.name = name;
        this.ads = ads;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> tags) {
        this.ads = ads;
    }

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

}
