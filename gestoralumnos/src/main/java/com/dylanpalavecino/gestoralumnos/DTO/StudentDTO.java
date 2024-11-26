package com.dylanpalavecino.gestoralumnos.DTO;


import com.dylanpalavecino.gestoralumnos.entity.StudentStatus;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO  {

    private Long id;
    private String name;
    private String lastname;
    private Date birthdate;
    private String email;
    private String phone;


}
