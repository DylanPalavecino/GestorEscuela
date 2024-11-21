package com.dylanpalavecino.gestoralumnos.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Setter
@Getter
@RequiredArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    final private String resourceName;
    final private String fieldName;
    final private Long fieldValue;


    public ResourceNotFoundException(String fieldName, Long fieldValue, String resourceName) {

        super(String.format("%s not found in %s : %s ", fieldName, resourceName));

        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
    }


}
