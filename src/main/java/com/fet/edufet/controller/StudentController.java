package com.fet.edufet.controller;

import com.fet.edufet.dto.StudentDto;
import com.fet.edufet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

//    @GetMapping("/students")
//    public ResponseEntity<List<StudentDto>> getAll() {
//        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
//    }
}
