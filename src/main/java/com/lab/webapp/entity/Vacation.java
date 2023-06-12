package com.lab.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacations")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacation")
    private Long id;
    @Column
    private String type_vacation;
    @Column
    private int payment_vacation;
    @Column
    private String vacation_benefits;
    @OneToMany
    @JoinColumn(name = "id_document")
    private Set<DocumentVacation> documents;


    public Vacation(Long id) {
        this.id = id;
        this.type_vacation="unknown";
        this.payment_vacation=0;
        this.vacation_benefits="unknown";

    }
}
