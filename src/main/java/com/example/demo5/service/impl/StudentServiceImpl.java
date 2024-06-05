package com.example.demo5.service.impl;

import com.example.demo5.dto.StudentDto;
import com.example.demo5.entity.Student;
import com.example.demo5.mapper.StudentMapper;
import com.example.demo5.mapper.impl.StudentMapperImpl;
import com.example.demo5.repository.StudentRepository;
import com.example.demo5.repository.impl.StudentRepositoryImpl;
import com.example.demo5.service.StudentService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository = new StudentRepositoryImpl();
    StudentMapper studentMapper = new StudentMapperImpl();

    @Override
    public StudentDto getStudentById(Long id) {
        return null;
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.getAll();
        return students.stream()
                .map(studentMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(Long id) {
        Optional<List<Student>> optionalStudents = studentRepository.getById(String.valueOf(id));
        if (optionalStudents.isPresent()) {
            List<Student> students = optionalStudents.get();
            if (!CollectionUtils.isEmpty(students)) {
                return studentMapper.entityToDto(students.get(0));
            }
        }
        return null;
    }

    @Override
    public List<StudentDto> getByFirstName(String firstName) {
        Optional<List<Student>> optionalStudents = studentRepository.getByFirstName(firstName);
        if (optionalStudents.isPresent()) {
            List<Student> students = optionalStudents.get();
            if (!CollectionUtils.isEmpty(students)) {
                return students.stream()
                        .map(studentMapper::entityToDto)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}

