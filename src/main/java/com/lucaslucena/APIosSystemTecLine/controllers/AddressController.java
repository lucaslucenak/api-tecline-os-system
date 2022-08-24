package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;
    final ModelMapper modelMapper;

    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public AddressModel saveAddress(@RequestBody AddressModel address) {
        addressService.setAddressUpperCase(address);
        addressService.setAddressUpperCase(address);
        return addressService.saveAddress(address);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AddressModel findAddressById(@PathVariable("id") Long id) {
        return addressService.findAddressById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<AddressModel> findAllAddress() {
        return addressService.findAllAddresses();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAddressById(@PathVariable("id") Long id) {
        addressService.findAddressById(id)
                .map(address -> {
                    addressService.deleteAddressById(address.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateAddress(@PathVariable("id") Long id, @RequestBody AddressModel newAddress) {
        addressService.findAddressById(id)
                .map(address -> {
                    modelMapper.map(newAddress, address);
                    addressService.setAddressUpperCase(address);
                    addressService.setAddressUpperCase(address);
                    addressService.saveAddress(address);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }
}
