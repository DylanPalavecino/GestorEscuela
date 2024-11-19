package com.dylanpalavecino.gestoralumnos.mapper;

import com.dylanpalavecino.gestoralumnos.DTO.StudentDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.StudentStatus;
import org.springframework.stereotype.Component;


@Component
public class StudentEntityToDTO implements IMapper<Student, StudentDTO> {




    @Override
    public StudentDTO map(Student input) {

        StudentDTO student = new StudentDTO();
        student.setId(input.getId());
        student.setName(input.getName());
        student.setLastname(input.getLastname());
        student.setBirthdate(input.getBirthdate());

        return student;

    }
}
