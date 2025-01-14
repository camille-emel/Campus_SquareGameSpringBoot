package com.example.demo.gamecatalog.dao;
import jakarta.persistence.*;

@Entity
@Table(name = "game_user")
public class GameUser {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    private String email;

    protected GameUser(){}

    public GameUser(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
