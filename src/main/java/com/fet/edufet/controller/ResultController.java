package com.fet.edufet.controller;

import com.fet.edufet.dto.NewResultDto;
import com.fet.edufet.dto.ResultDto;
import com.fet.edufet.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ResultController {

    private ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }


    @GetMapping("/result/{studentId}")
    public ResponseEntity<List<ResultDto>> getResultOfStudent(@PathVariable Integer studentId) {
        return new ResponseEntity<>(service.getOne(studentId), HttpStatus.OK);
    }

    @PostMapping("/result/{studentId}")
    public ResponseEntity<ResultDto> saveOneResultOfStudent(@PathVariable Integer studentId, @RequestBody NewResultDto dto) {
        return new ResponseEntity<>(service.saveOne(studentId, dto),HttpStatus.CREATED);
    }

    @PutMapping("/result/{resultId}/{studentId}")
    public ResponseEntity<?> editOneResultOfStudent(@PathVariable Integer resultId, @PathVariable Integer studentId, NewResultDto dto) {
        service.edit(resultId,studentId,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/result/{resultId}")
    public ResponseEntity<?> deleteOneResultOfStudent(@PathVariable Integer resultId) {
        service.delOne(resultId);
        return ResponseEntity.noContent().build();
    }

}
