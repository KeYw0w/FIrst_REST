package com.lab.webapp.controller;

import com.lab.webapp.entity.DocumentVacation;
import com.lab.webapp.entity.Employee;
import com.lab.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import java.util.*;

import static org.springframework.util.ClassUtils.isPresent;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employee_repo;

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


    @GetMapping("/deleteEmployee")
    public String deleteDocument(@RequestParam Long EmployeeId) {

        employee_repo.deleteAllById(Collections.singleton(EmployeeId));
        return "redirect:/listempl";
    }

    @PostMapping("/saveEmployee")
    public String saveDocument(@ModelAttribute Employee employee) {

        employee_repo.save(employee);
        return "redirect:/listempl";
    }

    @GetMapping("/addEmployee")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        mav.addObject("Employee", employee);
        return mav;
    }

    @GetMapping("/showUpdateFormEmpl")
    public ModelAndView ShowUpdateFormEmployee(@RequestParam long EmployeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Optional<Employee> optionalEmployee;
        optionalEmployee = employee_repo.findById(EmployeeId);
        Employee employee = new Employee();
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();

        }
        mav.addObject("Employee", employee);
        return mav;
    }

    @GetMapping("/ShowEmployeesDocs")
    public ModelAndView ShowDocs(@RequestParam long EmployeeId) {
        Optional<Employee> optionalEmployee;
        Employee employee = new Employee();
        ModelAndView mav = new ModelAndView("list-employeesDocs");

        optionalEmployee = employee_repo.findById(EmployeeId);
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();

        }
        List<DocumentVacation> documents = null;

//        mav.addObject("document", );
        documents = employee.getDocuments();
//        for (int i = 0; i<documents.size();i++){
        mav.addObject("listOfDocuments",documents);
//            mav.addObject("list",documents.get(i));
//        }
//        documents.forEach(s -> mav.addObject("document",));

        return mav;
    }
}
