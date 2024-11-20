package com.dylanpalavecino.gestoralumnos.controller;

import com.dylanpalavecino.gestoralumnos.DTO.StudentDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.StudentRequest;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentRequest studentRequest) {

         return this.studentService.createStudent(studentRequest);

    }

    @GetMapping("/show_all")
    public List<Student> showAllStudents() {

        return this.studentService.showAllStudents();

    }

}
