package com.lab.webapp.dto;

import com.lab.webapp.Entity.document_vacation;
import com.lab.webapp.Entity.employee;
import com.lab.webapp.dao.document_vacationRepo;
import com.lab.webapp.dao.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


//@Slf4j
@Controller
public class document_vacationDTO {
    @Autowired
    private document_vacationRepo documentVacationRepo;
    @Autowired
    employeeRepo employeeRepod;

    @GetMapping({"/list", "/"})
    public ModelAndView getallDocuments() {
        ModelAndView mav = new ModelAndView("list-documents");
        mav.addObject("document", documentVacationRepo.findAll());
        return mav;
    }


    @GetMapping("/addDocumentForm")
    public ModelAndView addDocumentForm() {
        ModelAndView mav = new ModelAndView("add-document-form");
        document_vacation vacation_d = new document_vacation();
        mav.addObject("document", vacation_d);
        return mav;
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute document_vacation vacation_d) {
        documentVacationRepo.save(vacation_d);
        return "redirect:/list";

    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long DocumentId) {
        System.out.println("sadasdada");
        ModelAndView mav = new ModelAndView("add-document-form");
        Optional<document_vacation> optionalvacation_d = documentVacationRepo.findById(DocumentId);
        document_vacation document_vacation = new document_vacation();
        if (optionalvacation_d.isPresent()) {
            document_vacation = optionalvacation_d.get();

        }
        mav.addObject("document", document_vacation);
        return mav;
    }

    @GetMapping("/deleteStudent")
    public String deleteDocument(@RequestParam Long DocumentId) {

        documentVacationRepo.deleteAllById(Collections.singleton(DocumentId));
        return "redirect:/list";
    }

    @GetMapping("/GetDocumentByVa")
    public Object GetDocumentByVac(@RequestParam Long employeeId) {

        List<document_vacation> vacations = documentVacationRepo.findByemployeeId(1L);{

        }

//        mav.addObject("vacations",vacations);
//        return mav;
//        return vacations;
        return 1;
    }


}
