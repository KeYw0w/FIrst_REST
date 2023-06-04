package com.lab.webapp.dto;

import com.lab.webapp.Entity.document_vacation;
import com.lab.webapp.Entity.vacation;

import com.lab.webapp.dao.document_vacationRepo;
import com.lab.webapp.dao.vacationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class vacationDTO {
    @Autowired
    private vacationRepo vacation_repo;
    @Autowired
    private document_vacationRepo vacation_d_repo;

    @GetMapping({"/listvac", "/vac"})
    public ModelAndView getallVacations() {
        ModelAndView mav = new ModelAndView("list-vacations");
        mav.addObject("vacations", vacation_repo.findAll());
        return mav;
    }

    @GetMapping("/deleteVacation")
    public String DeleteVacation(@RequestParam Long vacationId) {
        vacation_repo.deleteAllById(Collections.singleton(vacationId));
        return "redirect:/listvac";


    }

    @PostMapping("/saveVacation")
    public String saveVacation(@ModelAttribute vacation vacation) {
        vacation_repo.save(vacation);
        return "redirect:/listvac";

    }

    @GetMapping("/addVacationForm")
    public ModelAndView AddVacation() {
        ModelAndView mav = new ModelAndView("add-vacation-form");
        vacation vacation_d = new vacation();
        mav.addObject(vacation_d);
        return mav;
    }

    @GetMapping("/showUpdateFormvac")
    public ModelAndView UpdateMac(@RequestParam Long vacationId) {
        ModelAndView mav = new ModelAndView("add-vacation-form");
        Optional<vacation> optionalVacation_d = vacation_repo.findById(vacationId);
        vacation vacation = new vacation();
        if (optionalVacation_d.isPresent()) {
            vacation = optionalVacation_d.get();

        }
        mav.addObject("vacation", vacation);
        return mav;
    }


}


