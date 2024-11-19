package com.dylanpalavecino.gestoralumnos.repository;


import com.dylanpalavecino.gestoralumnos.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {




}
