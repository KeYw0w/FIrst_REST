package com.lab.webapp.controller;

import com.lab.webapp.entity.DocumentVacation;
import com.lab.webapp.entity.Employee;
import com.lab.webapp.entity.Vacation;
import com.lab.webapp.repository.DocumentVacationRepository;
import com.lab.webapp.repository.EmployeeRepository;
import com.lab.webapp.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


//@Slf4j
@Controller
public class DocumentVacationController {
    private final DocumentVacationRepository documentVacationRepo;
    private final VacationRepository vacationRepository;
    private final EmployeeRepository employeeRepository;

    public DocumentVacationController(DocumentVacationRepository documentVacationRepo, VacationRepository vacationRepository, EmployeeRepository employeeRepository) {
        this.documentVacationRepo = documentVacationRepo;
        this.vacationRepository = vacationRepository;
        this.employeeRepository = employeeRepository;
    }


    @GetMapping({"/list", "/"})
    public ModelAndView getallDocuments() {
        ModelAndView mav = new ModelAndView("list-documents");
        mav.addObject("document", documentVacationRepo.findAll());
        return mav;
    }


    @GetMapping("/addDocumentForm")
    public ModelAndView addDocumentForm() {
        ModelAndView mav = new ModelAndView("add-document-form");
        DocumentVacation vacation_d = new DocumentVacation();
        mav.addObject("document", vacation_d);

//        System.out.println(mav.getModel().get("document"));


        return mav;
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute DocumentVacation vacation_d) {
//        System.out.println(vacation_d.toString());
//        Employee employee;
//        employee = new Employee(vacation_d.getEmployee().getId());
//
//        Vacation vacation;
//
//        vacation = new Vacation(vacation_d.getVacation().getId());
//        vacation_d.setVacation(vacation);
//        vacation_d.setEmployee(employee);
//        System.out.print(employee.toString());
////        employeeRepository.saveAndFlush(employee);
////        vacationRepository.save(vacation);
        documentVacationRepo.save(vacation_d);
        return "redirect:/list";

    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long DocumentId) {
        System.out.println("sadasdada");
        ModelAndView mav = new ModelAndView("add-document-form");
        Optional<DocumentVacation> optionalvacation_d = documentVacationRepo.findById(DocumentId);
        DocumentVacation DocumentVacation = new DocumentVacation();
        if (optionalvacation_d.isPresent()) {
            DocumentVacation = optionalvacation_d.get();

        }
        mav.addObject("document", DocumentVacation);
        return mav;
    }

    @GetMapping("/deleteStudent")
    public String deleteDocument(@RequestParam Long DocumentId) {

        documentVacationRepo.deleteAllById(Collections.singleton(DocumentId));
        return "redirect:/list";
    }

}
