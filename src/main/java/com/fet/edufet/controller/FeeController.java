package com.fet.edufet.controller;

import com.fet.edufet.dto.FeeDto;
import com.fet.edufet.dto.UpdateFeeDto;
import com.fet.edufet.service.FeeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FeeController {

    private FeeService service;

    public FeeController(FeeService service) {
        this.service = service;
    }

    @GetMapping("/fee")
    public ResponseEntity<List<FeeDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/fee/{studentId}")
    public ResponseEntity<FeeDto> getStudentFee(@PathVariable Integer studentId) {
        return new ResponseEntity<>(service.getOne(studentId),HttpStatus.OK);
    }

    @PostMapping("/fee/{studentId}")
    public ResponseEntity<FeeDto> saveStudentFee(@PathVariable Integer studentId, @RequestBody UpdateFeeDto dto) {
        return new ResponseEntity<>(service.saveOne(studentId,dto),HttpStatus.CREATED);
    }

    @PutMapping("/fee/{studentId}")
    public ResponseEntity<?> editFee(@PathVariable Integer studentId ,@RequestBody UpdateFeeDto dto) {
        service.editOne(studentId,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/fee/{studentId}")
    public ResponseEntity<?> deleteStudentFee(@PathVariable Integer studentId) {
        service.delOne(studentId);
        return ResponseEntity.noContent().build();
    }
}
