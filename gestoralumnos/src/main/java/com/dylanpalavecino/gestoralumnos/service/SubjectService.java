package com.dylanpalavecino.gestoralumnos.service;

import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectRequestToSubjectEntity;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectEntityToDTO;
import com.dylanpalavecino.gestoralumnos.repository.ProfessorRepository;
import com.dylanpalavecino.gestoralumnos.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SubjectService {


    private final SubjectRepository subjectRepository;
    private final SubjectEntityToDTO subjectEntityToDTO;
    private final SubjectRequestToSubjectEntity subjectRequestToSubjectEntity;
    private final ProfessorRepository professorRepository;


    // CREAR LA MATERIA

    public SubjectDTO createSubject(SubjectRequest subjectRequest) {

        Subject subject = subjectRequestToSubjectEntity.map(subjectRequest);

        return subjectEntityToDTO.map(subjectRepository.save(subject));

    }

    //MOSTRAR UNA MATERIA POR ID

    public SubjectDTO showSubjectById(Long id) {

        return subjectEntityToDTO.map(subjectRepository.findById(id).orElse(null));

    }

    //MOSTRAR TODAS LAS MATERIAS EN LA DB

    public List<SubjectDTO> findAllSubjects() {

        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream().map(subject -> subjectEntityToDTO.map(subject)).collect(Collectors.toList());

    }



    //ASIGNAR UN PROFESOR A LA MATERIA A TRAVES DE ID

    public SubjectDTO assignProfessorById(Long id, Long professorId) {


        Subject subject = subjectRepository.findById(id).orElse(null);

        Professor professor = professorRepository.findById(professorId).orElse(null);

        subject.getProfessors().add(professor);

        return subjectEntityToDTO.map(subjectRepository.save(subject));


    }




}
