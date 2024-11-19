package com.dylanpalavecino.gestoralumnos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private Date birthdate;

    @ManyToMany
    @JoinTable(name="students_subjects", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;
    private StudentStatus status;





}
