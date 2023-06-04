package com.lab.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lab.webapp.Entity.employee;

@Repository
public interface employeeRepo extends JpaRepository<employee,Long> {
}
