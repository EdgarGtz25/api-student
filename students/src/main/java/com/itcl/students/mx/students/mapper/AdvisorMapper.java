package com.itcl.students.mx.students.mapper;

import com.itcl.students.mx.students.dto.AdvisorDTO;
import com.itcl.students.mx.students.entity.Advisor;

import java.util.stream.Collectors;

public class AdvisorMapper {

    public static AdvisorDTO toDTO(Advisor entity) {
        return AdvisorDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .subjectIds(entity.getSubjects()
                        .stream()
                        .map(s -> s.getId())
                        .collect(Collectors.toList()))
                .build();
    }
}