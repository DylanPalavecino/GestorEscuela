package com.dylanpalavecino.gestoralumnos.mapper;

import com.dylanpalavecino.gestoralumnos.DTO.ProfessorDTO;
import com.dylanpalavecino.gestoralumnos.entity.Professor;
import org.springframework.stereotype.Component;


@Component
public class ProfessorEntityToDTO implements IMapper<Professor, ProfessorDTO> {


    @Override
    public ProfessorDTO map(Professor input) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setName(input.getName());
        dto.setLastname(input.getLastname());
        dto.setDepartment(input.getDepartment());
        return dto;
    }
}
