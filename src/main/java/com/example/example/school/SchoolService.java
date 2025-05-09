package com.example.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDto create(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        var savedSchool = repository.save(school);
        return schoolMapper.toSchoolDto(savedSchool);
    }

    public List<SchoolDto> findAll() {
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }


}
