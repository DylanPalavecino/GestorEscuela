package com.dylanpalavecino.gestoralumnos.service;

import com.dylanpalavecino.gestoralumnos.DTO.ProfessorDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.ProfessorRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.exceptions.ResourceNotFoundException;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorEntityToDTO;
import com.dylanpalavecino.gestoralumnos.mapper.ProfessorRequestToProfessorEntity;
import com.dylanpalavecino.gestoralumnos.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {


    private final ProfessorEntityToDTO professorEntityToDTO;
    private final ProfessorRequestToProfessorEntity professorRequestToProfessorEntity;
    private final ProfessorRepository professorRepository;

    //Crear un profesor

    public ProfessorDTO createProfessor(ProfessorRequest professorRequest) {

        Professor professor = professorRequestToProfessorEntity.map(professorRequest);

        return professorEntityToDTO.map(this.professorRepository.save(professor));

    }
    //Mostrar todos los profesores

    public List<Professor> findAllProfessors() {

        return professorRepository.findAll();

    }
    //Mostrar un profesor

    public ProfessorDTO findProfessorById(Long id) {

        return professorEntityToDTO.map(professorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Professor", "id", id)));


    }

    //Eliminar profesor por id

    public void deleteProfessor(Long id) {

        Professor professor = professorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Professor", "id", id));
        professorRepository.delete(professor);

    }

    //Actualizar profesor por id




}
