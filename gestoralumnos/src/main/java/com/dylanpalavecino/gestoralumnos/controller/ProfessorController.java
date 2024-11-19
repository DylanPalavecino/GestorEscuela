package com.dylanpalavecino.gestoralumnos.controller;


import com.dylanpalavecino.gestoralumnos.DTO.ProfessorDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.ProfessorRequest;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorRequestToProfessorEntity;
import com.dylanpalavecino.gestoralumnos.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professors")
public class ProfessorController {


    private final ProfessorService professorService;

    @PostMapping("/create_professor")
    public ProfessorDTO createProfessor (@RequestBody ProfessorRequest professorRequest) {

        return this.professorService.createProfessor(professorRequest);


    }





}
