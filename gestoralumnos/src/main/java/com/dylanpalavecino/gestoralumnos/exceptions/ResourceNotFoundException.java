package com.dylanpalavecino.gestoralumnos.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    final private String resourceName;
    final private String fieldName;
    final private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {

        super(String.format("%s not found in: %s : %s ",resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

}
