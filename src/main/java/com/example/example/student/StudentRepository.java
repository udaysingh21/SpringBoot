package com.example.example.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
        List<Student> findStudentByfnameContaining(String fname);

}
