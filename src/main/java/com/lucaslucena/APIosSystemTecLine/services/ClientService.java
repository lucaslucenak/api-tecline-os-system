package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.dto.ClientDto;
import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import com.lucaslucena.APIosSystemTecLine.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDto saveClient(ClientDto clientDto) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        clientModel.setId(clientDto.getId());
        clientModel.setName(clientDto.getName());
        clientModel.setCpf(clientDto.getCpf());
        clientModel.setPhone_number(clientDto.getPhone_number());
        clientModel.setEmail(clientDto.getEmail());
        clientModel.setAddress(new AddressModel(clientDto.getAddress_id()));
        clientModel = clientRepository.save(clientModel);
        return new ClientDto(clientModel);
    }

    public Optional<ClientModel> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<ClientDto> findAllClients() {
        List<ClientModel> clientModel = clientRepository.findAll();
        return clientModel.stream().map(x -> new ClientDto(x)).toList();
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public void setClientUpperCase(ClientModel clientModel) {
        clientModel.setName(clientModel.getName().toUpperCase());
        clientModel.setCpf(clientModel.getCpf().toUpperCase());
        clientModel.setPhone_number(clientModel.getPhone_number().toUpperCase());
        clientModel.setEmail(clientModel.getEmail().toUpperCase());
    }
}
