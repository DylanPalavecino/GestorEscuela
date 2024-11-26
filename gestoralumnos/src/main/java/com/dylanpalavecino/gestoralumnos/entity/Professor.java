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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "dni" }) })

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true , nullable = false)
    private String dni;
    @Column(nullable = false)
    private String department;
    private String email;
    private String phone;
    @Column(nullable = false)
    private String cuit;

    @ManyToMany
    @JoinTable(name = "subjects_professors", joinColumns = @JoinColumn(name="professor_id"), inverseJoinColumns = @JoinColumn(name="subject_id"))
    private List<Subject> subjects;


}
