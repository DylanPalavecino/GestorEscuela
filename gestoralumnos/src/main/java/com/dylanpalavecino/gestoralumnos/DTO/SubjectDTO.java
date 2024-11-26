package com.dylanpalavecino.gestoralumnos.DTO;


import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.SubjectShift;
import lombok.Data;

import java.util.List;

@Data
public class SubjectDTO {

    private Long id;
    private String name;
    private String committee;
    private SubjectShift subjectShift;

}
