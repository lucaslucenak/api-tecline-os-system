package com.lucaslucena.APIosSystemTecLine.models;

import javax.persistence.*;
import java.util.UUID;

public class Assistent {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;
}
