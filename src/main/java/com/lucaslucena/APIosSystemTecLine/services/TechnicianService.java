package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.models.TechnicianModel;
import com.lucaslucena.APIosSystemTecLine.repositories.TechnicianRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public TechnicianModel saveTechnician(TechnicianModel technician) {
        return technicianRepository.save(technician);
    }

    public Optional<TechnicianModel> findTechnicianById(Long id) {
        return technicianRepository.findById(id);
    }

    public List<TechnicianModel> findAllTechnicians() {
        return technicianRepository.findAll();
    }

    public void deleteTechnicianById(Long id) {
        technicianRepository.deleteById(id);
    }

    public void setTechnicianUpperCase(TechnicianModel technicianModel) {
        technicianModel.setName(technicianModel.getName().toUpperCase());
        technicianModel.setCpf(technicianModel.getCpf().toUpperCase());
        technicianModel.setPhone_number(technicianModel.getPhone_number().toUpperCase());
        technicianModel.setEmail(technicianModel.getEmail().toUpperCase());
    }
}
