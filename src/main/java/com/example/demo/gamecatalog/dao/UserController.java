package com.example.demo.gamecatalog.dao;

import com.example.demo.gamecatalog.dao.GameUser;
import com.example.demo.gamecatalog.dao.MySQLUserDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody GameUser user) {
        boolean isAdded = userDAO.addUser(user);

        if (isAdded) {
            return ResponseEntity.ok("Utilisateur ajouté avec succès !");
        } else {
            return ResponseEntity.status(500).body("Erreur lors de l'ajout de l'utilisateur.");
        }
    }

}
