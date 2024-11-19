package com.dylanpalavecino.gestoralumnos.controller;

import com.dylanpalavecino.gestoralumnos.DTO.StudentDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create_student")
    public StudentDTO createStudent(@RequestBody StudentRequest studentRequest) {

         return this.studentService.createStudent(studentRequest);

    }


}
