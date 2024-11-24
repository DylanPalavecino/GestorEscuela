package com.dylanpalavecino.gestoralumnos.mapper;


import com.dylanpalavecino.gestoralumnos.controller.request.SubjectRequest;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectRequestToSubjectEntity implements IMapper<SubjectRequest, Subject>{




    @Override
    public Subject map(SubjectRequest input) {

        Subject subject = new Subject();
        subject.setName(input.getName());
        subject.setCommittee(input.getCommittee());
        subject.setSubjectShift(input.getSubjectShift());

        return subject;

    }


}
