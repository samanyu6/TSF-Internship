package com.samanyu.restapi.demo.repository;

import com.samanyu.restapi.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface studentRepository extends JpaRepository<Student, Long> {
}
