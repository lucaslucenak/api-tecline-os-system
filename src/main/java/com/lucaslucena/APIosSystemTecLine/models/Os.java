package com.lucaslucena.APIosSystemTecLine.models;

import com.lucaslucena.APIosSystemTecLine.enumns.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "tb_os")
public class Os {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private Client client;

    @OneToOne
    private Assistent assistent;

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
    private final LocalDate pickup_limit_date = finished_date.plusDays(15);

    @Column
    private String observation;
}
