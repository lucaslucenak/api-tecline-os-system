package com.lucaslucena.APIosSystemTecLine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity(name = "tb_client")
@Getter
@Setter
public class ClientModel extends RepresentationModel<ClientModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "id_address")
    private AddressModel address;
}
