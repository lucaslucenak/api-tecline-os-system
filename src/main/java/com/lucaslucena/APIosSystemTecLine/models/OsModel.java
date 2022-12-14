package com.lucaslucena.APIosSystemTecLine.models;

import com.lucaslucena.APIosSystemTecLine.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tb_os")
@Getter
@Setter
public class OsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_client")
    private ClientModel client;

    @OneToOne
    @JoinColumn(name = "id_technician")
    private TechnicianModel technician;

    @Column
    private String equipment;

    @Column
    private Double estimated_value;

    @Column
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod payment_method;

    @Column
    private Integer installments;

    @Column
    private Integer payed_installments;

    @Column
    private final LocalDate issued_date = LocalDate.now();

    @Column
    private LocalDate finished_date;

    @Column
    private LocalDate pickup_limit_date;

    @Column
    private String observation;
}
