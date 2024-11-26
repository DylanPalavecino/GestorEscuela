package com.dylanpalavecino.gestoralumnos.service;


import com.dylanpalavecino.gestoralumnos.DTO.StudentDTO;
import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.exceptions.ResourceNotFoundException;
import com.dylanpalavecino.gestoralumnos.mapper.StudentRequestToStudentEntity;
import com.dylanpalavecino.gestoralumnos.mapper.StudentEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectEntityToDTO;
import com.dylanpalavecino.gestoralumnos.repository.StudentRepository;
import com.dylanpalavecino.gestoralumnos.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentRequestToStudentEntity studentRequestToStudentEntity;
    private final StudentEntityToDTO studentEntityToDTO;
    private final SubjectRepository subjectRepository;
    private final SubjectEntityToDTO subjectEntityToDTO;

    //Crear estudiante
    public StudentDTO createStudent(StudentRequest studentRequest) {

        Student student = studentRequestToStudentEntity.map(studentRequest);

        return studentEntityToDTO.map(this.studentRepository.save(student));

    }
    //Mostrar estudiantes
    public List<Student> findAllStudents (){

        return studentRepository.findAll();

    }
    //Mostrar estudiante por id

    public StudentDTO showStudentById(Long id) {

        return studentEntityToDTO.map(studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "id", id)));


    }

    //Eliminar estudiante
    public void deleteStudent (Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","id", id));

        studentRepository.delete(student);

    }

    //Actualizar estudiante
    public StudentDTO updateStudent (Long id, StudentRequest studentRequest) {

        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","id", id));
        student.setName(studentRequest.getName());
        student.setLastname(studentRequest.getLastname());
        student.setBirthdate(studentRequest.getBirthdate());
        student.setDni(studentRequest.getDni());
        student.setPhone(studentRequest.getPhone());
        student.setEmail(studentRequest.getEmail());

        return studentEntityToDTO.map(this.studentRepository.save(student));

    }

}
