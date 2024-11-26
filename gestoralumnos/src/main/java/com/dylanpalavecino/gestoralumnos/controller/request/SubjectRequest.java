package com.dylanpalavecino.gestoralumnos.controller.request;


import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.SubjectShift;
import lombok.*;

import java.util.List;


@Data
public class SubjectRequest {

    private SubjectShift subjectShift;
    private String name;
    private String committee;

}
