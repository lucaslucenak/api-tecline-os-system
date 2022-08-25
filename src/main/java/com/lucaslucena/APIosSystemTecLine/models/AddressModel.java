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

    @OneToMany(mappedBy = "address")
    private List<ClientModel> clients = new ArrayList<>();
}
