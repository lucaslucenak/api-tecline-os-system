package com.lucaslucena.APIosSystemTecLine.repositories;

import com.lucaslucena.APIosSystemTecLine.models.OsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<OsModel, Long> {
}
