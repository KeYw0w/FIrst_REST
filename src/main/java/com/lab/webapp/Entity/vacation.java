package com.lab.webapp.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="vacations")
public class vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vacation")
    private Long id;
    @Column(name="type_vacation")
    private String type_vacation;
    @Column(name="payment_vacation")
    private int payment_vacation;
    @Column(name="vacation_benefits")
    private String vacation_benefits;




}
