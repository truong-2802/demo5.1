package com.example.demo5.controller;

import com.example.demo5.dto.StudentDto;
import com.example.demo5.service.StudentService;
import com.example.demo5.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudentController {
    StudentService studentService = new StudentServiceImpl();
    // api/v1/student/1  .. and httpMethod  = GET
    @GetMapping(value = "/student/{studentId}")
    public StudentDto get(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @GetMapping(value = "/student")
    public List<StudentDto> getAll(){
        return studentService.findAll();
    }
    @GetMapping(value = "/student/search")
    public List<StudentDto> getByFirstName(@RequestParam("firstName") String firstName){
        return studentService.getByFirstName(firstName);
    }

}