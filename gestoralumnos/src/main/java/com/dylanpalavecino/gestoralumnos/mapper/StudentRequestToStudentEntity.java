package com.dylanpalavecino.gestoralumnos.mapper;

import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.StudentStatus;
import org.springframework.stereotype.Component;


@Component
public class StudentRequestToStudentEntity implements IMapper<StudentRequest, Student>{


    @Override
    public Student map(StudentRequest input) {

        Student student = new Student();
        student.setName(input.getName());
        student.setLastname(input.getLastname());
        student.setDni(input.getDni());
        student.setBirthdate(input.getBirthdate());
        student.setStatus(StudentStatus.ACTIVE);
        student.setEmail(input.getEmail());
        student.setPhone(input.getPhone());


        return student;
    }




}
