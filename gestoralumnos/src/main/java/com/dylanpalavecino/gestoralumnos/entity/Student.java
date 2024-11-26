package com.dylanpalavecino.gestoralumnos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "dni" }) })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private Date birthdate;
    private StudentStatus status;
    private String email;
    private String phone;

    @ManyToMany
    @JoinTable(name="students_subjects", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;


}
