package com.itcl.students.mx.students.service;

import com.itcl.students.mx.students.dto.AdvisorDTO;

import java.util.List;

public interface AdvisorService {
    List<AdvisorDTO> findAll();
    AdvisorDTO findById(Long id);
    AdvisorDTO create(AdvisorDTO dto);
    AdvisorDTO update(Long id, AdvisorDTO dto);
    void delete(Long id);
}