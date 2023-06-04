package com.lab.webapp.dao;

import com.lab.webapp.Entity.vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface vacationRepo extends JpaRepository<vacation,Long> {

}
