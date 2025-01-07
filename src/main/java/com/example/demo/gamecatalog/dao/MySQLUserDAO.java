//package com.example.demo.gamecatalog.dao;
//
//import org.apache.catalina.User;
//import org.springframework.stereotype.Component;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class MySQLUserDAO implements UserDAO {
//
//    @Override
//    public List<GameUser> getAllUsers() {
//        List<GameUser> users = new ArrayList<>();
//        String query = "SELECT * FROM USERS";
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//
//            while (resultSet.next()) {
//
//                GameUser user = new GameUser(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    @Override
//    public GameUser getUserById(int id) {
//        String query = "SELECT * FROM USERS WHERE id = ?"; // Utilisation d'une requête paramétrée
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setInt(1, id);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    return new GameUser(id, resultSet.getString("name"), resultSet.getString("email"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null; // Retourne null si aucun utilisateur n'est trouvé
//    }
//
//
//    @Override
//    public boolean addUser(GameUser user) {
//        String query = "INSERT INTO USERS (name, email) VALUES (?, ?)";
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            // Définir les paramètres
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//
//            // Exécuter la requête
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            // Retourne true si l'utilisateur a été ajouté avec succès
//            return rowsAffected > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false; // Retourne false en cas d'échec
//        }
//    }
//
//
//    @Override
//    public boolean updateUser(GameUser user) {
//        String query = "UPDATE USERS SET name = ?, email = ? WHERE id = ?";
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            // Définir les paramètres
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setInt(3, user.getId());
//
//            // Exécuter la requête
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            // Retourne true si une ou plusieurs lignes ont été affectées
//            return rowsAffected > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // Retourne false en cas d'erreur ou si aucun utilisateur n'a été trouvé
//        return false;
//    }
//
//    @Override
//    public boolean deleteUser(int id) {
//        String query = "DELETE FROM USERS WHERE id = ?";
//
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            // Définir le paramètre (ID de l'utilisateur à supprimer)
//            preparedStatement.setInt(1, id);
//
//            // Exécuter la requête
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            // Retourne true si une ou plusieurs lignes ont été affectées
//            return rowsAffected > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // Retourne false en cas d'erreur ou si aucun utilisateur n'a été supprimé
//        return false;
//    }
//
//}
