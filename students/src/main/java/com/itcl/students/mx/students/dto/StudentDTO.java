package com.itcl.students.mx.students.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
}