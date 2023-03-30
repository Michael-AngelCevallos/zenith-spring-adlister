package com.codeup.zenithspringadlister.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
    @Table(name="ads")
    public class Ad {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false, length = 100)
        private String title;
        @Column(nullable = false)
        private String description;
        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name ="user id")// allows us to control the name of the column)
        private User user;
        @ManyToMany(cascade = CascadeType.PERSIST)
        @JoinTable (
                name = "ads tags",
                joinColumns = @JoinColumn(name = "ad id"),
                inverseJoinColumns = @JoinColumn( name = "tag id")
        ) // IMPORTANT USE @JoinTable For whichever Model is the PARENT TABLE <-------------
        private Set<Tag> tags;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Ad() {
        }

        public Ad(String title, String description) {
            this.title = title;
            this.description = description;
        }


        public Ad(String title, String description, User user) {
            this.title = title;
            this.description = description;
            this.user = user;
        }


    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }



