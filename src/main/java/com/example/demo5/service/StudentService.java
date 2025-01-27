package com.example.demo5.service;

import com.example.demo5.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(Long id);
    List<StudentDto> findAll();

    StudentDto getById(Long id);
    List<StudentDto> getByFirstName(String firstName);
}

