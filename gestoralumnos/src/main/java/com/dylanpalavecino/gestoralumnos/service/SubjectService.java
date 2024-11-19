package com.dylanpalavecino.gestoralumnos.service;

import com.dylanpalavecino.gestoralumnos.DTO.SubjectDTO;
import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectRequestToSubjectEntity;
import com.dylanpalavecino.gestoralumnos.mapper.SubjectEntityToDTO;
import com.dylanpalavecino.gestoralumnos.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SubjectService {


    private final SubjectRepository subjectRepository;
    private final SubjectEntityToDTO subjectEntityToDTO;
    private final SubjectRequestToSubjectEntity subjectRequestToSubjectEntity;

    public SubjectDTO createSubject(SubjectRequest subjectRequest) {

        Subject subject = subjectRequestToSubjectEntity.map(subjectRequest);

        return subjectEntityToDTO.map(subjectRepository.save(subject));



    }


}
