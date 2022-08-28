package com.lucaslucena.APIosSystemTecLine.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "tb_address")
@Getter
@Setter
public class AddressModel {

    public AddressModel(Long id, String street, String number, String cep, String neighborhood, String city, String complement) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
        this.complement = complement;
    }

    public AddressModel(Long id) {
        this.id = id;
    }

    public AddressModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String cep;

    @Column
    private String neighborhood;

    @Column
    private String city;

    @Column
    private String complement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")/*(mappedBy = "address")*/
//    @JoinColumn(name = "address")
    private List<ClientModel> clients;
}
