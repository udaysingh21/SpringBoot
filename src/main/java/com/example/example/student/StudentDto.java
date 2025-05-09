package com.example.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Firstname should not be empty")
        String fname,

        @NotEmpty(message = "Lastname should not be empty")
        String lname,

        @Email(message = "Format of Email entered is incorrect")
        String email,

        Integer schoolId

) {
}
