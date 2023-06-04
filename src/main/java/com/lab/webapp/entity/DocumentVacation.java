package com.lab.webapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents_vacations")
public class DocumentVacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Long id;
    @Column(name = "nubmer_document")
    private int number;
    @Column(name = "date_registration")
    private String registration_date;
    @Column(name = "date_start")
    private String start_date;
    @Column(name = "date_end")
    private String end_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vacation")
    private Vacation vacation;





}
