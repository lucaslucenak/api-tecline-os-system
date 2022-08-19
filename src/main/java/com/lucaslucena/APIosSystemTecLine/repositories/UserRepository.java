package com.lucaslucena.APIosSystemTecLine.repositories;

import com.lucaslucena.APIosSystemTecLine.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findUserByUsername(String username);
}
