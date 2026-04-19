package com.itcl.students.mx.students.repository;

import com.itcl.students.mx.students.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}