package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressModel saveAddress(@RequestBody AddressModel address) {
        return addressService.saveAddress(address);
    }

    @GetMapping("/{id}")
    public AddressModel findAddressById(@PathVariable("id") Long id) {
        return addressService.findAddressById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressModel> findAllAddress() {
        return addressService.findAllAddresses();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddressById(@PathVariable("id") Long id) {
        addressService.findAddressById(id)
                .map(address -> {
                    addressService.deleteAddressById(address.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }
}
