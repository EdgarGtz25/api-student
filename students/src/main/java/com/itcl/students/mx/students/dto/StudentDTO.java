package com.itcl.students.mx.students.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;

    private Long advisorId;      // 🔥 importante
    private List<Long> subjectIds;
}