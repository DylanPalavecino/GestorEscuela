package com.dylanpalavecino.gestoralumnos.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class StudentRequest {


    private String name;
    private String lastname;
    private String dni;
    private Date birthdate;



}