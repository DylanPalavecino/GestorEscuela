package com.dylanpalavecino.gestoralumnos.repository;

import com.dylanpalavecino.gestoralumnos.entity.Professor;
import com.dylanpalavecino.gestoralumnos.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
