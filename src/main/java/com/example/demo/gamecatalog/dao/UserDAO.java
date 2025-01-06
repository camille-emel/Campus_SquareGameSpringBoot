package com.example.demo.gamecatalog.dao;

import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {
    public List<GameUser> getAllUsers();
    public GameUser getUserById(int id);
    public boolean addUser(GameUser user);
    public void updateUser(GameUser user);
    public void deleteUser(int id);
}
