package com.lab.webapp.controller;

import com.lab.webapp.entity.DocumentVacation;
import com.lab.webapp.repository.DocumentVacationRepository;
import com.lab.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


//@Slf4j
@Controller
public class DocumentVacationController {
    @Autowired
    private DocumentVacationRepository documentVacationRepo;


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
        return mav;
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute DocumentVacation vacation_d) {
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
