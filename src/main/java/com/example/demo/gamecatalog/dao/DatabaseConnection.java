package com.example.demo.gamecatalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/square_games",
                        "root",
                        "root"

                );
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erreur de connexion");
            }
        }
        return connection;
    }
}
