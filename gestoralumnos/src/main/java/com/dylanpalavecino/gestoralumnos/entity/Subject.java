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
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors;
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
    @Column(nullable = false)
    private String committee;
    //TURNO DE LA MATERIA -- MORNING, LATE, NIGHT
    @Column(nullable = false)
    private SubjectShift subjectShift;
    private transient final int QUOTA = 3;


}



