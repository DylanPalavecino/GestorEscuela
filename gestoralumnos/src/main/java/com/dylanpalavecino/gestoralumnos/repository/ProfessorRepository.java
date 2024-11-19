package com.dylanpalavecino.gestoralumnos.repository;

import com.dylanpalavecino.gestoralumnos.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
