package com.dylanpalavecino.gestoralumnos.controller;


import com.dylanpalavecino.gestoralumnos.DTO.SubjectAssignProfessorsDTO;
import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.exceptions.ProfessorAlreadyAsignedException;
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

    //GET
    @GetMapping("/")
    public List<SubjectDTO> findAllSubjects() {

        return subjectService.findAllSubjects();

    }

    @GetMapping("/{id}")
    public SubjectDTO findSubject(@PathVariable final Long id) {

        return this.subjectService.showSubjectById(id);

    }

    //POST
    @PostMapping("/create")
    public SubjectDTO createSubject(@RequestBody final SubjectRequest subjectRequest) {
        return this.subjectService.createSubject(subjectRequest);
    }

    @PostMapping("/assign_professor/{id}/{professorId}")
    public SubjectAssignProfessorsDTO assignProfessor(@PathVariable final Long id, @PathVariable final Long professorId) throws ProfessorAlreadyAsignedException {

        return this.subjectService.assignProfessorById(id, professorId);

    }

    @PostMapping("/assign_student/{id}/{studentId}")
    public SubjectDTO assignStudent(@PathVariable final Long id, @PathVariable final Long studentId) throws Exception {

        return this.subjectService.assignStudentById(id, studentId);

    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteSubject (@PathVariable final Long id){

        subjectService.deleteSubject(id);

    }

    //PUT
    @PutMapping("/update/{id}")
    public SubjectDTO updateSubject( @RequestBody final SubjectRequest subjectRequest, @PathVariable final Long id) {

        SubjectDTO subjectDTO;
        subjectDTO = subjectService.updateSubject(subjectRequest, id);
        return subjectDTO;

    }

}
