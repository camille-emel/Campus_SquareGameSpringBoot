package com.example.demo.gamecatalog.dao;

import com.example.demo.gamecatalog.dao.GameUser;
//import com.example.demo.gamecatalog.dao.MySQLUserDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    private final MySQLUserDAO userDAO = new MySQLUserDAO();

    @GetMapping("/")
    public List<GameUser> getAllUsers() {
        return userRepository.findAll();
    }

//    @GetMapping("/{userId}")
//    public GameUser getUserById(@PathVariable int userId) {
//        return userDAO.getUserById(userId);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> addUser(@RequestBody GameUser user) {
//        boolean isAdded = userDAO.addUser(user);
//
//        if (isAdded) {
//            return ResponseEntity.ok("Utilisateur ajouté avec succès !");
//        } else {
//            return ResponseEntity.status(500).body("Erreur lors de l'ajout de l'utilisateur.");
//        }
//    }
//    @PutMapping("/{id}")
//    public String updateUser(@PathVariable int id, @RequestBody GameUser user) {
//        GameUser updatedUser = new GameUser(id, user.getName(), user.getEmail());
//        userDAO.updateUser(updatedUser);
//        return "User updated (if existed).";
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody GameUser user) {
////        // Associer l'ID de la route à l'objet GameUser
//////        GameUser user = new GameUser(id);
//////        user.setId(id);
////
////
////        // Appeler la méthode DAO pour mettre à jour l'utilisateur
////        boolean isUpdated = userDAO.updateUser(user);
////
////        if (isUpdated) {
////            return ResponseEntity.ok("Utilisateur mis à jour avec succès !");
////        } else {
////            return ResponseEntity.status(404).body("Aucun utilisateur trouvé avec l'ID spécifié.");
////        }
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable int id) {
//        boolean isDeleted = userDAO.deleteUser(id);
//
//        if (isDeleted) {
//            return ResponseEntity.ok("Utilisateur supprimé avec succès !");
//        } else {
//            return ResponseEntity.status(404).body("Aucun utilisateur trouvé avec l'ID spécifié.");
//        }
}


//}
