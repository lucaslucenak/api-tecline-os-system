package com.lucaslucena.APIosSystemTecLine.models;

import com.lucaslucena.APIosSystemTecLine.enumns.PaymentMethod;
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
    private ClientModel client;

    @OneToOne
    private TechnicianModel technician;

    @Column
    private Double estimated_value;

    @Column
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

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
