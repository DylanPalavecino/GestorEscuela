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

    @GetMapping("/")
    public List<Student> findAllStudents() {

        return this.studentService.findAllStudents();

    }

    //Encontrar estudiante
    @GetMapping("/{id}")
    public StudentDTO findStudentById(@PathVariable Long id) {

        return this.studentService.showStudentById(id);

    }

    @PutMapping("/update/{id}")
    public StudentDTO updateStudent(@PathVariable final Long id, @RequestBody final StudentRequest studentRequest) {

        StudentDTO studentDTO;
        studentDTO = studentService.updateStudent(id, studentRequest);
        return studentDTO;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable final Long id) {

        studentService.deleteStudent(id);


    }


}
