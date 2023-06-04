package com.lab.webapp.repository;

import com.lab.webapp.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends JpaRepository<Vacation,Long> {

}
