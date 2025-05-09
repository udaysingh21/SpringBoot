package com.example.example.student;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


// If there is any business logic or if there is any operations performed , it should be in Service class.
@Service
public class StudentService   {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }


    public StudentResponseDto saveStudents(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.studentResponseDto(savedStudent);
    }

    public List<StudentResponseDto>getAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentMapper::studentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getAllStudentsById(Integer id) {
        return repository.findById(id)
                .map(studentMapper::studentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByName(String name) {
        return repository.findStudentByfnameContaining(name)
                .stream()
                .map(studentMapper::studentResponseDto)
                   .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
