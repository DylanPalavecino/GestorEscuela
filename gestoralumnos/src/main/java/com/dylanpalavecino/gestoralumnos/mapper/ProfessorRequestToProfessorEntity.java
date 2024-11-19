package com.dylanpalavecino.gestoralumnos.mapper;


import com.dylanpalavecino.gestoralumnos.controller.request.ProfessorRequest;
import com.dylanpalavecino.gestoralumnos.entity.Professor;

public class ProfessorRequestToProfessorEntity implements IMapper<ProfessorRequest, Professor> {



    @Override
    public Professor map(ProfessorRequest input) {

        Professor professor = new Professor();
        professor.setName(input.getName());
        professor.setLastname(input.getLastname());
        professor.setDepartment(input.getDepartment());
        professor.setDni(input.getDni());
        return professor;

    }
}
