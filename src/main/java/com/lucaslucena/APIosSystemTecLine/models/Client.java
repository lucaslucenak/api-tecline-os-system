package com.lucaslucena.APIosSystemTecLine.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "tb_client")
@Getter
@Setter
public class Client {

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
