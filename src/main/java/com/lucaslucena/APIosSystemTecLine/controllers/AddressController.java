package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
}
