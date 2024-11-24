package com.dylanpalavecino.gestoralumnos.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProfessorRequest {


    private String name;
    private String lastname;
    private String dni;
    private String department;
    private String email;
    private String phone;
    private String cuit;





}
