package com.itcl.students.mx.students.service;


import com.itcl.students.mx.students.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> findAll();
    SubjectDTO findById(Long id);
    SubjectDTO create(SubjectDTO dto);
    SubjectDTO update(Long id, SubjectDTO dto);
    void delete(Long id);
}