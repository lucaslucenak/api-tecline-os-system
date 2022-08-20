package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import com.lucaslucena.APIosSystemTecLine.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel saveClient(@RequestBody ClientModel client) {
        return clientService.saveClient(client);
    }

    @GetMapping("{id}")
    public ClientModel findClientById(@PathVariable("id") Long id) {
        return clientService.findClientById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientModel> findAllClients() {
        return clientService.findAllClients();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteClientById(@PathVariable("id") Long id) {
        clientService.findClientById(id)
                .map(client -> {
                    clientService.deleteClientById(client.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

}
