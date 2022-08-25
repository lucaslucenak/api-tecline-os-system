package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.OsModel;
import com.lucaslucena.APIosSystemTecLine.models.TechnicianModel;
import com.lucaslucena.APIosSystemTecLine.services.OsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/os")
public class OsController {

    final OsService osService;
    final ModelMapper modelMapper;

    public OsController(OsService osService, ModelMapper modelMapper) {
        this.osService = osService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OsModel saveOs(@RequestBody OsModel os) {
        osService.setOsUpperCase(os);
        return osService.saveOs(os);
    }

    @GetMapping("{id}")
    public OsModel findOsById(@PathVariable("id") Long id) {
        return osService.findOsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OS not found"));
    }

    @GetMapping
    public List<OsModel> findAllOs() {
        return osService.findAllOs();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteOsById(@PathVariable("id") Long id) {
        osService.findOsById(id)
                .map(os -> {
                    osService.deleteOsById(os.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OS not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOs(@PathVariable("id") Long id, @RequestBody OsModel newOs) {
        osService.findOsById(id)
                .map(os -> {
                    modelMapper.map(newOs, os);
                    osService.setOsUpperCase(os);
                    osService.saveOs(os);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OS not found"));
    }
}
