package com.example.example.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// Ideally controller layer should be responsible for receiving the requests and sending back the responses.
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudents(@Valid   @RequestBody StudentDto dto) {
        return studentService.saveStudents(dto);

    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponseDto getAllStudentsById(@PathVariable("id") Integer id) {
//        return repository.findById(id);
        return studentService.getAllStudentsById(id);
    }


    @GetMapping("/students/search/{student_name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("student_name") String name) {
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
         studentService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldname = ((FieldError) error).getField();
            var errormessage = error.getDefaultMessage();
            errors.put(fieldname,errormessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
