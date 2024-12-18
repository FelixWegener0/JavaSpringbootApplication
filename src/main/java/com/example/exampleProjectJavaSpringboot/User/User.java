package com.example.exampleProjectJavaSpringboot.User;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String first_name;

    private String last_name;

    private LocalDateTime created_at;

    private String mobileAppToken;


    public Integer getId() {
        return id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public String getMobileAppToken() {
        return mobileAppToken;
    }

    public void setCreatedAt() {
        this.created_at = LocalDateTime.now();
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setMobileAppToken(String token) {
        this.mobileAppToken = token;
    }
}
