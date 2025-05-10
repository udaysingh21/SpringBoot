package com.example.example.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudentClass() {
        StudentDto dto = new StudentDto("Vikram",
                "Singh",
                "vs21@gmail.com",
                1
        );
        Student student = mapper.toStudent(dto);

        // assertEquals() is a method used in testing to check if two values are the same.
        // If they are not , test fails
        Assertions.assertEquals(dto.fname(),student.getFname());
        Assertions.assertEquals(dto.lname(),student.getLname());
        Assertions.assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(),student.getSchool().getId());

    }

    @Test
    public void shouldThrowNullPointerExceptionWhenMapStudentDtoToStudentWhenStudentDtoIsNull() {
        var message = assertThrows(NullPointerException.class,() -> mapper.toStudent(null));
        assertEquals("The Student Dto should not be null",message.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResposneDto() {
        Student student = new Student("Vikram","Singh","vs21@gmail.com",24);

        StudentResponseDto repsonse = mapper.studentResponseDto(student);

        Assertions.assertEquals(repsonse.fname(),student.getFname());
        Assertions.assertEquals(repsonse.lname(),student.getLname());
        Assertions.assertEquals(repsonse.email(),student.getEmail());

    }

}