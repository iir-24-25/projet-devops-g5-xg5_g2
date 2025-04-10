package org.example.gestion_stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String passwordHash;
    private String email;
    @Enumerated
    private role role;

    public User(){}
    public User(long id, String username, String passwordHash, String email, org.example.gestion_stock.model.role role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public org.example.gestion_stock.model.role getRole() {
        return role;
    }

    public void setRole(org.example.gestion_stock.model.role role) {
        this.role = role;
    }
}
