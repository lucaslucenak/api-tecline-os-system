package com.lucaslucena.APIosSystemTecLine.repositories;

import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
