package com.itcl.students.mx.students.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvisorDTO {
    private Long id;
    private String name;
    private String email;
    private List<Long> subjectIds;
}
