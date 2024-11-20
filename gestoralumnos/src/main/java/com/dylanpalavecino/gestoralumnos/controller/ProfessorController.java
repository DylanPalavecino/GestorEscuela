package com.dylanpalavecino.gestoralumnos.controller;


import com.dylanpalavecino.gestoralumnos.DTO.ProfessorDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.ProfessorRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorRequestToProfessorEntity;
import com.dylanpalavecino.gestoralumnos.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professors")
public class ProfessorController {


    private final ProfessorService professorService;

    @PostMapping("/create")
    public ProfessorDTO createProfessor (@RequestBody ProfessorRequest professorRequest) {

        return this.professorService.createProfessor(professorRequest);


    }

    @GetMapping("/show_all")
    public List<Professor> showAllProfessors() {

        return this.professorService.showAllProfessors();

    }




}
