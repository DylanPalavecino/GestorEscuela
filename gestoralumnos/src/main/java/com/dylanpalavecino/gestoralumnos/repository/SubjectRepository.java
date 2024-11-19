package com.dylanpalavecino.gestoralumnos.repository;

import com.dylanpalavecino.gestoralumnos.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
