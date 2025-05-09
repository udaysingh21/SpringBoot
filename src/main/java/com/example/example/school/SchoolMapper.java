package com.example.example.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolDto toSchoolDto(School school) {
        // this is for response back to school dto
        return new SchoolDto(school.getName());
    }

    public School toSchool(SchoolDto dto) {
//        converting schooldto to school to save in db
        return new School(dto.name());
    }

}
