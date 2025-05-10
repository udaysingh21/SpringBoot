package com.example.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // which service we want to test
    @InjectMocks // it will tell to mock the dependencies
    private StudentService studentService;

    // declare the dependencies and mock it
    @Mock
    private StudentRepository studentRepository;
    private  StudentMapper studentMapper = new StudentMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullySaveStudent() {
        // Given - studentdto object and student object
        StudentDto dto = new StudentDto("Vikram",
                "Singh",
                "vvs21@gmail.com",
                1
        );

        Student student = new Student(
                "Vikram",
                "Singh",
                "vvs21@gmail.com",
                1
        );

        Student savedStudent = new Student(
                "Vikram",
                "Singh",
                "vvs21@gmail.com",
                1
        );
        savedStudent.getId(1);

        // We need to mock the calls as we are in isolation of dependencies
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.studentResponseDto(savedStudent))
                  .thenReturn(new StudentResponseDto("Vikram","Singh","fhbv@gmail.com"));

        // When
        StudentResponseDto studentResponseDto = studentService.saveStudents(dto);

        // Then
        assertEquals(dto.fname(),studentResponseDto.fname());
        assertEquals(dto.lname(),studentResponseDto.lname());
        assertEquals(dto.email(),studentResponseDto.email());

        verify(studentMapper,times(1)).toStudent(dto);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).studentResponseDto(savedStudent);
    }
}