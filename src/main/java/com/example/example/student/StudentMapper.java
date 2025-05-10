package com.example.example.student;

import com.example.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    // Function that converts a StudentDto to a Student object
    public Student toStudent(StudentDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("The StudentDto should not be null");
        }

        var student = new Student();
        student.setFname(dto.fname());
        student.setLname(dto.lname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    // Function to create a StudentResponseDto from Student object
    public StudentResponseDto studentResponseDto(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student object cannot be null");
        }

        return new StudentResponseDto(
                student.getFname(),
                student.getLname(),
                student.getEmail()
        );
    }
}
