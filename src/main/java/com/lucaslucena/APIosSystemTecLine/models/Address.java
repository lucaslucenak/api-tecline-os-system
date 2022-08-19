package com.lucaslucena.APIosSystemTecLine.models;

import javax.persistence.*;
import java.util.UUID;

public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Client owner;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String cep;

    @Column
    private String Neighborhood;

    @Column
    private String city;

    @Column
    private String complement;
}
