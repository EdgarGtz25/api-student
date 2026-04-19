package com.itcl.students.mx.students.repository;

import com.itcl.students.mx.students.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}