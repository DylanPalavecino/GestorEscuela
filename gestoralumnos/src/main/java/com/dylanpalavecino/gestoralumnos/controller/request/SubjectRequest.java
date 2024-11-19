package com.dylanpalavecino.gestoralumnos.controller.request;


import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.SubjectShift;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SubjectRequest {


    private SubjectShift subjectShift;
    private String name;
    private List<Long> professorsId;
    private String committee;




}
