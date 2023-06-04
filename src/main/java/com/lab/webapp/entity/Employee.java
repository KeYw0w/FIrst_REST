package com.lab.webapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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
    private String firstName;
    private String secondName;
    private String patronymic;
    private String position;
    private String department;
    private String employment_date;
}

