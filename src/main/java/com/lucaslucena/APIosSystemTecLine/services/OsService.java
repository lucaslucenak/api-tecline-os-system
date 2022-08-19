package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.models.OsModel;
import com.lucaslucena.APIosSystemTecLine.repositories.OsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsService {

    final OsRepository osRepository;

    public OsService(OsRepository osRepository) {
        this.osRepository = osRepository;
    }

    public OsModel saveOs(OsModel os) {
        return osRepository.save(os);
    }

    public Optional<OsModel> findOsById(Long id) {
        return osRepository.findById(id);
    }

    public List<OsModel> findAllOs() {
        return osRepository.findAll();
    }

    public void deleteOsById(Long id) {
        osRepository.deleteById(id);
    }
}
