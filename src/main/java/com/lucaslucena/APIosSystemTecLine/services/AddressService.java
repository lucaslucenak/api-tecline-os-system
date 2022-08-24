package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressService {

    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressModel saveAddress(AddressModel address) {
        return addressRepository.save(address);
    }

    public List<AddressModel> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<AddressModel> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    public void setAddressUpperCase(AddressModel addressModel) {
        addressModel.setStreet(addressModel.getStreet().toUpperCase());
        addressModel.setNumber(addressModel.getNumber().toUpperCase());
        addressModel.setCep(addressModel.getCep().toUpperCase());
        addressModel.setNeighborhood(addressModel.getNeighborhood().toUpperCase());
        addressModel.setCity(addressModel.getCity().toUpperCase());
        addressModel.setComplement(addressModel.getComplement().toUpperCase());
    }
}
