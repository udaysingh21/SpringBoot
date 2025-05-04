package com.example.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository repository;


    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student postStudents(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getAllStudents(@PathVariable("id") Integer id) {
//        return repository.findById(id);
        return Optional.of(repository.findById(id).orElse(new Student()));
    }

    @GetMapping("/students/search/{student_name}")
    public List<Student> findStudentByName(@PathVariable("student_name") String name) {
        return repository.findStudentByfnameContaining(name);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

}
