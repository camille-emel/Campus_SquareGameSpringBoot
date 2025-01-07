package com.example.demo.gamecatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserRepository extends JpaRepository<GameUser, Long> {
    void GameUser();

    List<GameUser> findByName(String name);
    List<GameUser> findByEmail(String email);
    List<GameUser> findAll();

}
