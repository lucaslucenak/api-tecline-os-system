package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.TechnicianModel;
import com.lucaslucena.APIosSystemTecLine.services.TechnicianService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    final TechnicianService technicianService;
    final ModelMapper modelMapper;

    public TechnicianController(TechnicianService technicianService, ModelMapper modelMapper) {
        this.technicianService = technicianService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TechnicianModel saveTechnician(@RequestBody TechnicianModel technician) {
        return technicianService.saveTechnician(technician);
    }

    @GetMapping("{id}")
    public TechnicianModel findTechnicianById(@PathVariable("id") Long id) {
        return technicianService.findTechnicianById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Technician not found"));
    }

    @GetMapping
    public List<TechnicianModel> findAllTechnicians() {
        return technicianService.findAllTechnicians();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteTechnicianById(@PathVariable("id") Long id) {
        technicianService.findTechnicianById(id)
                .map(technician -> {
                    technicianService.deleteTechnicianById(technician.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Technician not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTechnician(@PathVariable("id") Long id, @RequestBody TechnicianModel newTechnician) {
        technicianService.findTechnicianById(id)
                .map(technician -> {
                    modelMapper.map(newTechnician, technician);
                    technicianService.saveTechnician(technician);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Technician not found"));
    }
}
