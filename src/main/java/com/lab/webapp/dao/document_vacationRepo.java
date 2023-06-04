package com.lab.webapp.dao;


import com.lab.webapp.Entity.employee;
import com.lab.webapp.Entity.vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.webapp.Entity.document_vacation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface document_vacationRepo extends JpaRepository<document_vacation, Long> {
    List<document_vacation> findByemployeeId(Long employeeId);
}
