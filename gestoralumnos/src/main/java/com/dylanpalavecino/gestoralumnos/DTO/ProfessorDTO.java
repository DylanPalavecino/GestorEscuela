package com.dylanpalavecino.gestoralumnos.DTO;

import lombok.Data;

@Data
public class ProfessorDTO {

    private Long id;
    private String name;
    private String lastname;
    private String department;
    private String dni;
    private String email;
    private String phone;
    private String cuit;

}
