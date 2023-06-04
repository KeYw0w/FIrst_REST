package com.lab.webapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.attoparser.IDocumentHandler;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@Table(name = "documents_vacations")
public class document_vacation {
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
    private employee employeeId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_vacation",referencedColumnName = "id_vacation"    )
    private vacation vacationId;


    public document_vacation() {
    }


}
