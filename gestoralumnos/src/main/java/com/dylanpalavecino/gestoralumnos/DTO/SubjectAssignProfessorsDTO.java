package com.dylanpalavecino.gestoralumnos.DTO;

import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.SubjectShift;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record SubjectAssignProfessorsDTO(Long id, String name, String committee, SubjectShift subjectShift, List<ProfessorDTO> professors) {




}
