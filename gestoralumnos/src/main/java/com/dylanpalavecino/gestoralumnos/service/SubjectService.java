package com.dylanpalavecino.gestoralumnos.service;

import com.dylanpalavecino.gestoralumnos.DTO.SubjectAssignProfessorsDTO;
import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.exceptions.ProfessorAlreadyAsignedException;
import com.dylanpalavecino.gestoralumnos.exceptions.ResourceNotFoundException;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectRequestToSubjectEntity;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectEntityToDTO;
import com.dylanpalavecino.gestoralumnos.repository.ProfessorRepository;
import com.dylanpalavecino.gestoralumnos.repository.StudentRepository;
import com.dylanpalavecino.gestoralumnos.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectEntityToDTO subjectEntityToDTO;
    private final SubjectRequestToSubjectEntity subjectRequestToSubjectEntity;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final ProfessorEntityToDTO professorEntityToDTO;

    //Crear una materia
    public SubjectDTO createSubject(SubjectRequest subjectRequest) {

        Subject subject = subjectRequestToSubjectEntity.map(subjectRequest);

        return subjectEntityToDTO.map(subjectRepository.save(subject));

    }

    //Mostrar materia por id
    public SubjectDTO showSubjectById(Long id) {

        return subjectEntityToDTO.map(subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subject", "id", id )));

    }

    //Mostrar materias
    public List<SubjectDTO> findAllSubjects() {

        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream().map(subject -> subjectEntityToDTO.map(subject)).collect(Collectors.toList());

    }

    //Asignar profesor a materia
    public SubjectAssignProfessorsDTO assignProfessorById(Long id, Long professorId) throws ProfessorAlreadyAsignedException {

        Subject subject = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subject", "id", id ));

        Professor professor = professorRepository.findById(professorId).orElseThrow(()->new ResourceNotFoundException("Professor", "id", professorId));

        if(subject.getProfessors().contains(professor)) {

            throw new ProfessorAlreadyAsignedException("El profesor ya esta asignado a la materia");

        }

        subject.getProfessors().add(professor);
        professor.getSubjects().add(subject);

        professorRepository.save(professor);
        subjectRepository.save(subject);

        return SubjectAssignProfessorsDTO.builder()
                .name(subject.getName())
                .committee(subject.getCommittee())
                .subjectShift(subject.getSubjectShift())
                .professors(subject.getProfessors().stream().map((p)->professorEntityToDTO.map(p)).collect(Collectors.toList()))
                .build();

    }
    //Asignar alumno a materia

    public SubjectDTO assignStudentById(Long id, Long studentId) throws Exception {

        Subject subject = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subject", "id", id ));

        Student student= studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student", "id", studentId));

        if(subject.getStudents().size() >= subject.getQUOTA()){

            throw new Exception("Subject quota is full");

        }

        subject.getStudents().add(student);
        student.getSubjects().add(subject);
        studentRepository.save(student);

        return subjectEntityToDTO.map(subjectRepository.save(subject));

    }

    //Eliminar materia
    public void deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subject", "id", id));
        subjectRepository.delete(subject);
    }

    //Actualizar materia
    public SubjectDTO updateSubject(SubjectRequest subjectRequest, Long id) {

           Subject subject = subjectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subject", "id", id));
           subject.setName(subjectRequest.getName());
           subject.setCommittee(subjectRequest.getCommittee());
           subject.setSubjectShift(subjectRequest.getSubjectShift());

           return subjectEntityToDTO.map(subjectRepository.save(subject));

    }

}
