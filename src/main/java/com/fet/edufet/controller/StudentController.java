package com.fet.edufet.controller;

import com.fet.edufet.dto.StudentDto;
import com.fet.edufet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(service.getOne(id),HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> saveUser(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(service.save(studentDto),HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> modifyUser(@PathVariable Integer id , @RequestBody StudentDto dto) {
        service.update(id,dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        service.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
