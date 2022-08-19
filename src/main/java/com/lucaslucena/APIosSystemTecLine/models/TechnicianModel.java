package com.lucaslucena.APIosSystemTecLine.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "tb_technician")
@Getter
@Setter
public class TechnicianModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_address")
    private AddressModel address;
}
