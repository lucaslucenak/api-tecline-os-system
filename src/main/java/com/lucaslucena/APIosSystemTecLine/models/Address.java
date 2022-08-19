package com.lucaslucena.APIosSystemTecLine.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "tb_address")
@Getter
@Setter
public class Address {

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
    private String Neighborhood;

    @Column
    private String city;

    @Column
    private String complement;
}
