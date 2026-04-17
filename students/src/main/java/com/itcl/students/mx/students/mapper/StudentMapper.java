package com.itcl.students.mx.students.mapper;

import com.itcl.students.mx.students.dto.StudentDTO;
import com.itcl.students.mx.students.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
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