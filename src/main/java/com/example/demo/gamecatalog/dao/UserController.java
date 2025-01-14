package com.example.demo.gamecatalog.dao;

import com.example.demo.gamecatalog.dao.GameUser;
//import com.example.demo.gamecatalog.dao.MySQLUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private  UserRepository userRepository;

    @GetMapping("/")
    public List<GameUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public Optional<GameUser> getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }

    @PostMapping
    public GameUser addUser(@RequestBody GameUser user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody GameUser user) {
        Optional<GameUser> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            GameUser existingUser = existingUserOptional.get();

            // Mettre à jour les champs
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());

            // Enregistrer les modifications
            userRepository.save(existingUser);

            return ResponseEntity.ok("User updated successfully.");
        } else {
            // Retourner une réponse 404 si l'utilisateur n'existe pas
            return ResponseEntity.status(404).body("User not found.");
        }
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);

    }
}



