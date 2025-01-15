package com.example.demo.gamecatalog.dao;
import jakarta.persistence.*;

@Entity
@Table(name = "game_user")
public class GameUser {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles;

    protected GameUser(){}

    public GameUser(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
