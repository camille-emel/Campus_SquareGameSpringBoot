package com.example.demo.gamecatalog.dao;

import com.example.demo.gamecatalog.dao.GameUser;
import com.example.demo.gamecatalog.dao.MySQLUserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private final MySQLUserDAO userDAO = new MySQLUserDAO();

    @GetMapping("/")
    public List<GameUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @GetMapping("/{userId}")
    public GameUser getUserById(@PathVariable int userId) {
        return userDAO.getUserById(userId);
    }
}
