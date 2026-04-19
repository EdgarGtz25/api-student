package com.itcl.students.mx.students.mapper;

import com.itcl.students.mx.students.dto.SubjectDTO;
import com.itcl.students.mx.students.entity.Subject;

public class SubjectMapper {

    public static SubjectDTO toDTO(Subject entity) {
        return SubjectDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Subject toEntity(SubjectDTO dto) {
        return Subject.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}