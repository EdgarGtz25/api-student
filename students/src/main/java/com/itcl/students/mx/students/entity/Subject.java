package com.itcl.students.mx.students.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 👇 Relación inversa con estudiantes
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    // 👇 Relación inversa con asesores
    @ManyToMany(mappedBy = "subjects")
    private List<Advisor> advisors;
}