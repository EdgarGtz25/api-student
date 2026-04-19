package com.itcl.students.mx.students.mapper;

import com.itcl.students.mx.students.dto.AdvisorDTO;
import com.itcl.students.mx.students.entity.Advisor;
import com.itcl.students.mx.students.entity.Subject;
import com.itcl.students.mx.students.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdvisorMapper {

    public static AdvisorDTO toDTO(Advisor advisor) {
        return AdvisorDTO.builder()
                .id(advisor.getId())
                .name(advisor.getName())
                .email(advisor.getEmail())
                .subjectIds(
                        advisor.getSubjects() == null
                                ? List.of()
                                : advisor.getSubjects()
                                .stream()
                                .map(Subject::getId)
                                .collect(Collectors.toList())
                )
                .build();
    }
    public static Advisor toEntity(AdvisorDTO dto, SubjectRepository subjectRepository) {

        Advisor advisor = Advisor.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

        if (dto.getSubjectIds() != null) {
            List<Subject> subjects = dto.getSubjectIds()
                    .stream()
                    .map(subjectRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            advisor.setSubjects(subjects);
        } else {
            advisor.setSubjects(new ArrayList<>());
        }

        return advisor;
    }
}