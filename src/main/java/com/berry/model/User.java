package com.berry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private boolean verified;
    private Date updated_at;
    private Date created_at;
    private String remember_token;

    public boolean isVerified() {
        return verified;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
