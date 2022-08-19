package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import com.lucaslucena.APIosSystemTecLine.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientModel saveClient(ClientModel client) {
        return clientRepository.save(client);
    }

    public Optional<ClientModel> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<ClientModel> findAllClients() {
        return clientRepository.findAll();
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
