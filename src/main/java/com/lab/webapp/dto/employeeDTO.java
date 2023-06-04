package com.lab.webapp.controller;

import com.lab.webapp.Entity.document_vacation;
import com.lab.webapp.Entity.employee;
import com.lab.webapp.dao.employeeRepo;
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
public class employeeDTO {
    @Autowired
    private employeeRepo employee_repo;

    @GetMapping({"/listempl", "/empl"})
    public ModelAndView getallEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", employee_repo.findAll());
        return mav;
    }
//    @GetMapping("/addDocumentForm")
//    public ModelAndView addDocumentForm() {
//        ModelAndView mav = new ModelAndView("add-document-form");
//        document_vacation vacation_d = new document_vacation();
//        mav.addObject("document_vacation", vacation_d);
//        return mav;
//    }

    @PostMapping("/saveemployee")
    public String saveemployee(@ModelAttribute employee employee_d) {
        employee_repo.save(employee_d);
        return "redirect:/list";

    }

    @GetMapping("/showUpdateFormEmpl")
    public ModelAndView showUpdateForm(@RequestParam long employeeId) {
        ModelAndView mav = new ModelAndView("add-vacation-form");
        Optional<employee> optionalEmployee = employee_repo.findById(employeeId);
        employee Employee = new employee();
        if (optionalEmployee.isPresent()) {
            Employee = optionalEmployee.get();

        }
        mav.addObject("employees", Employee);
        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteDocument(@RequestParam Long employeeId) {

        employee_repo.deleteAllById(Collections.singleton(employeeId));
        return "redirect:/list";
    }
    @PostMapping("/saveEmployee")
    public String saveDocument(@ModelAttribute employee employee) {

        employee_repo.save(employee);
        return "redirect:/list";
    }
    @GetMapping("/addEmployee")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        document_vacation vacation_d = new document_vacation();
        mav.addObject("document_vacation", vacation_d);
        return mav;
    }

}
