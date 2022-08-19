package com.lucaslucena.APIosSystemTecLine.repositories;

import com.lucaslucena.APIosSystemTecLine.models.TechnicianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<TechnicianModel, Long> {
}
