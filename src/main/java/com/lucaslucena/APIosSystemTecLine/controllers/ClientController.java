package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import com.lucaslucena.APIosSystemTecLine.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/client")
public class ClientController {

    final ClientService clientService;
    final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ClientModel saveClient(@RequestBody ClientModel client) {
        return clientService.saveClient(client);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ClientModel findClientById(@PathVariable("id") Long id) {
        return clientService.findClientById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<ClientModel> findAllClients() {
        return clientService.findAllClients();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteClientById(@PathVariable("id") Long id) {
        clientService.findClientById(id)
                .map(client -> {
                    clientService.deleteClientById(client.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize("hasRole('ADMIN')")
    public void updateClient(@PathVariable("id") Long id, @RequestBody ClientModel newClient) {
        clientService.findClientById(id)
                .map(client -> {
                    modelMapper.map(newClient, client);
                    clientService.saveClient(client);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }


}
