package com.lucaslucena.APIosSystemTecLine.models;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.UUID;

public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_address")
    private Client owner;
}
