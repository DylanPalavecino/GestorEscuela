package com.dylanpalavecino.gestoralumnos.mapper;

import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectEntityToDTO implements IMapper<Subject, SubjectDTO>{



    @Override
    public SubjectDTO map(Subject input) {

        SubjectDTO dto = new SubjectDTO();
        dto.setId(input.getId());
        dto.setName(input.getName());
        dto.setCommittee(input.getCommittee());
        dto.setSubjectShift(input.getSubjectShift());
        return dto;




    }
}
