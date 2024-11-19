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

public class Subject {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors;
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
    private String committee;
    private SubjectShift subjectShift;
    private transient final int QUOTA = 20;




}



