package com.lab.webapp.Entity;

import lombok.*;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long employeeId;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String second_name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "position")
    private String position;
    @Column(name = "department")
    private String department;
    @Column(name = "emplooyment_date")
    private String emplooyment_date;
//    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
//    private List<vacation> vacations;

//    @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL )
//    private Set<vacation> vacations;
}

