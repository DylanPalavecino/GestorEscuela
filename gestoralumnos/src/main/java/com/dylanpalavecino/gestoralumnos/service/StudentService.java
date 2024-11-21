package com.dylanpalavecino.gestoralumnos.service;


import com.dylanpalavecino.gestoralumnos.DTO.StudentDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.mapper.StudentRequestToStudentEntity;
import com.dylanpalavecino.gestoralumnos.mapper.StudentEntityToDTO;
import com.dylanpalavecino.gestoralumnos.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;
    private final StudentRequestToStudentEntity studentRequestToStudentEntity;
    private final StudentEntityToDTO studentEntityToDTO;


    public StudentDTO createStudent(StudentRequest studentRequest) {

        Student student = studentRequestToStudentEntity.map(studentRequest);

        return studentEntityToDTO.map(this.studentRepository.save(student));

    }

    public List<Student> findAllStudents (){

        return studentRepository.findAll();

    }

}
