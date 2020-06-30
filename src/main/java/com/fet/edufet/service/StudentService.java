package com.fet.edufet.service;

import com.fet.edufet.dto.StudentDto;
import com.fet.edufet.model.Student;
import com.fet.edufet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

//    public List<StudentDto> getAll() {
//        Iterable<Student> iterable = repository.findAll();
//        List<StudentDto> dtos = new ArrayList<>();
//
//
//    }
}
