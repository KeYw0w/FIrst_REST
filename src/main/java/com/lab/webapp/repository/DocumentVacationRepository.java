package com.lab.webapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.webapp.entity.DocumentVacation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentVacationRepository extends JpaRepository<DocumentVacation, Long> {

}
