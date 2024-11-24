package com.dylanpalavecino.gestoralumnos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects_professors")
public class SubjectsProfessors {

    private Long subjectId;
    private Long professorId;


}
