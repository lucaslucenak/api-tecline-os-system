package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.dto.AddressDto;
import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.services.AddressService;
import com.lucaslucena.APIosSystemTecLine.util.exceptions.InvalidCepException;
import com.lucaslucena.APIosSystemTecLine.util.validation.AddressValidator;
import com.lucaslucena.APIosSystemTecLine.util.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;
    final ModelMapper modelMapper;
    final Validator<AddressModel> addressModelValidator;

    public AddressController(AddressService addressService, ModelMapper modelMapper, AddressValidator addressModelValidator) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
        this.addressModelValidator = addressModelValidator;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasRole('ADMIN')")
    public AddressDto saveAddress(@RequestBody AddressDto addressDto) {
//        if (!addressModelValidator.isValid(address)) {
//            throw new InvalidCepException();
//        }
//        addressDto = addressService.saveAddress(addressDto);
//        addressService.setAddressUpperCase(address);
        return addressService.saveAddress(addressDto);
//        return addressService.saveAddress(address);
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

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateAddress(@PathVariable("id") Long id, @RequestBody AddressModel newAddress) {
//        addressService.findAddressById(id)
//                .map(address -> {
//                    modelMapper.map(newAddress, address);
//                    addressService.setAddressUpperCase(address);
//                    addressService.setAddressUpperCase(address);
//                    addressService.saveAddress(address);
//                    return Void.TYPE;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
//    }
}
