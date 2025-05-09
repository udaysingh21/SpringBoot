package com.example.example.student;

import com.example.example.school.School;
import org.springframework.stereotype.Service;

@Service
// Service Layers contains Business Logic, complex logic and provides separation of concerns
public class StudentMapper {
    // creating a function that converts object of StudentDto type into object of Student type so that we can use .save()
    public Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFname(dto.fname());
        student.setLname(dto.lname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    // creating this function to get a StudentDto response
    public StudentResponseDto studentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFname(),
                student.getLname(),
                student.getEmail()
        );
    }


}
