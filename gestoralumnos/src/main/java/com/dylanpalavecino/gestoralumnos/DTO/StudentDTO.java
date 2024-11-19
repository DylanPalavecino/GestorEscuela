package com.dylanpalavecino.gestoralumnos.DTO;


import lombok.Data;

import java.util.Date;


@Data
public class StudentDTO  {

    private Long id;
    private String name;
    private String lastname;
    private Date birthdate;



}
