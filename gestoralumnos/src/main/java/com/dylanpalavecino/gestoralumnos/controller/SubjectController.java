package com.dylanpalavecino.gestoralumnos.controller;


import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.service.SubjectService;
import jakarta.persistence.ManyToMany;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {


    private final SubjectService subjectService;

    public SubjectController(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create_subject")
    public SubjectDTO createSubject(@RequestBody final SubjectRequest subjectRequest) {
        return this.subjectService.createSubject(subjectRequest);
    }



}
