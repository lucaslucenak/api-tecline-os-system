package com.lucaslucena.APIosSystemTecLine.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_client")
@Getter
@Setter
public class ClientModel/* extends RepresentationModel<ClientModel>*/{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @Column
    private String phone_number;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "clients")
    private AddressModel address;
}
