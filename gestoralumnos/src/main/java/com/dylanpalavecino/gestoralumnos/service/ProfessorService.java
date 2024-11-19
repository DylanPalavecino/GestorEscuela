package com.dylanpalavecino.gestoralumnos.service;

import com.dylanpalavecino.gestoralumnos.DTO.ProfessorDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.ProfessorRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorRequestToProfessorEntity;
import com.dylanpalavecino.gestoralumnos.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {


    private final ProfessorEntityToDTO professorEntityToDTO;
    private final ProfessorRequestToProfessorEntity professorRequestToProfessorEntity;
    private final ProfessorRepository professorRepository;

    //CREAR PROFESOR

    public ProfessorDTO createProfessor(ProfessorRequest professorRequest) {

        Professor professor = professorRequestToProfessorEntity.map(professorRequest);


        return professorEntityToDTO.map(this.professorRepository.save(professor));

    }





}
