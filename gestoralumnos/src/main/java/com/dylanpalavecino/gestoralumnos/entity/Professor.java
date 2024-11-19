package com.dylanpalavecino.gestoralumnos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String department;

    @ManyToMany
    @JoinTable(name = "subjects_professors", joinColumns = @JoinColumn(name="professor_id"), inverseJoinColumns = @JoinColumn(name="subject_id"))
    private List<Subject> subjects;





}
