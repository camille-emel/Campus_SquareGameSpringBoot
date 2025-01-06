package com.example.demo.gamecatalog.dao;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySQLUserDAO implements UserDAO {

    @Override
    public List<GameUser> getAllUsers() {
        List<GameUser> users = new ArrayList<>();
        String query = "SELECT * FROM USERS";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                GameUser user = new GameUser();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public GameUser getUserById(int id) {
        String query = "SELECT * FROM USERS WHERE id = ?"; // Utilisation d'une requête paramétrée

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Définir le paramètre dans la requête
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // Si un résultat est trouvé
                    GameUser user = new GameUser(); // Instanciation de GameUser
                    user.setId(resultSet.getInt("id")); // Mapping des champs
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email")); // Ajouter d'autres champs si nécessaire
                    return user; // Retourne l'utilisateur trouvé
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retourne null si aucun utilisateur n'est trouvé
    }


    @Override
    public void addUser(GameUser user) {

    }

    @Override
    public void updateUser(GameUser user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
