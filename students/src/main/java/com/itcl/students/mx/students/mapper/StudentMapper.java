package com.itcl.students.mx.students.mapper;

import com.itcl.students.mx.students.dto.StudentDTO;
import com.itcl.students.mx.students.entity.Student;
import com.itcl.students.mx.students.entity.Subject;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .advisorId(
                        student.getAdvisor() != null ? student.getAdvisor().getId() : null
                )
                .subjectIds(
                        student.getSubjects() != null
                                ? student.getSubjects().stream().map(Subject::getId).toList()
                                : List.of()
                )
                .build();
    }

    public static Student toEntity(StudentDTO dto) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .build();
    }
}