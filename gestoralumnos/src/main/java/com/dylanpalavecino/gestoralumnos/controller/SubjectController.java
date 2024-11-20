package com.dylanpalavecino.gestoralumnos.controller;


import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.repository.SubjectRepository;
import com.dylanpalavecino.gestoralumnos.service.SubjectService;
import jakarta.persistence.ManyToMany;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {


    private final SubjectService subjectService;

    public SubjectController(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    public SubjectDTO createSubject(@RequestBody final SubjectRequest subjectRequest) {
        return this.subjectService.createSubject(subjectRequest);
    }
    @GetMapping("/show_all")
    public List<Subject> showAllSubjects() {

        return subjectService.showAllSubjects();

    }


    @PostMapping("/assign_professor/{id}/{professorId}")
    public SubjectDTO assignProfessor(@PathVariable final Long id, @PathVariable final Long professorId) {

        return this.subjectService.assignProfessorById(id, professorId);

    }

}
