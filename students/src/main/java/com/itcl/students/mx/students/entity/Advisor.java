package com.itcl.students.mx.students.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "advisors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    // 👇 Un asesor tiene muchos estudiantes
    @OneToMany(mappedBy = "advisor")
    private List<Student> students;

    // 👇 Puede impartir varias materias
    @ManyToMany
    @JoinTable(
            name = "advisor_subjects",
            joinColumns = @JoinColumn(name = "advisor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}