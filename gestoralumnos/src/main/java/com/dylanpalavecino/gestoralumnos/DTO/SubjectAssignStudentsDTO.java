package com.dylanpalavecino.gestoralumnos.DTO;

import com.dylanpalavecino.gestoralumnos.entity.Student;
import com.dylanpalavecino.gestoralumnos.entity.SubjectShift;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Builder
public record SubjectAssignStudentsDTO(Long id,String name,String committee,SubjectShift subjectShift, List<StudentDTO> students) {

}
