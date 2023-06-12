package com.lab.webapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id;



    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String patronymic;
    @Column
    private String position;
    @Column
    private String department;
    @Column(name="emplooyment_date")
    private String employment_date;
    @OneToMany(mappedBy = "employee")
    private List<DocumentVacation> Documents;

    public Employee(Long id) {
        this.id = id;
        this.employment_date="0001-01-01";
        this.department="unknown";
        this.firstName="unknown";
        this.secondName="unknown";
        this.position="unknown";
        
    }

    public Employee(String firstName, String secondName, String patronymic, String position, String department, String employment_date) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.position = position;
        this.department = department;
        this.employment_date = employment_date;
    }
}

