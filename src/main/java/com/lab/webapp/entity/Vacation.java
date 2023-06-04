package com.lab.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String type_vacation;
    private int payment_vacation;
    private String vacation_benefits;
    @OneToOne
    @JoinColumn(name = "id_document")
    private DocumentVacation documents;


}
