package com.lucaslucena.APIosSystemTecLine.dto;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class AddressDto {

    public AddressDto(Long id, String street, String number, String cep, String neighborhood, String city, String complement) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
        this.complement = complement;
    }
    
    public AddressDto(AddressModel addressModel) {
        id = addressModel.getId();
        this.street = addressModel.getStreet();
        this.number = addressModel.getNumber();
        this.cep = addressModel.getCep();
        this.neighborhood = addressModel.getNeighborhood();
        this.city = addressModel.getCity();
        this.complement = addressModel.getComplement();
    }


    private Long id;

    private String street;

    private String number;

    private String cep;

    private String neighborhood;

    private String city;

    private String complement;
}
