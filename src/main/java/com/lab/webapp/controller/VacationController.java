package com.lab.webapp.controller;

import com.lab.webapp.entity.Vacation;

import com.lab.webapp.repository.DocumentVacationRepository;
import com.lab.webapp.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Optional;

@Controller
public class VacationController {
    @Autowired
    private VacationRepository vacation_repo;
    @Autowired
    private DocumentVacationRepository vacation_d_repo;

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
    public String saveVacation(@ModelAttribute Vacation vacation) {
        vacation_repo.save(vacation);
        return "redirect:/listvac";

    }

    @GetMapping("/addVacationForm")
    public ModelAndView AddVacation() {
        ModelAndView mav = new ModelAndView("add-vacation-form");
        Vacation vacation_d = new Vacation();
        mav.addObject(vacation_d);
        return mav;
    }

    @GetMapping("/showUpdateFormvac")
    public ModelAndView UpdateMac(@RequestParam Long vacationId) {
        ModelAndView mav = new ModelAndView("add-vacation-form");
        Optional<Vacation> optionalVacation_d = vacation_repo.findById(vacationId);
        Vacation vacation = new Vacation();
        if (optionalVacation_d.isPresent()) {
            vacation = optionalVacation_d.get();

        }
        mav.addObject("vacation", vacation);
        return mav;
    }



}


