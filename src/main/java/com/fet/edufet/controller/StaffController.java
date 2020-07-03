package com.fet.edufet.controller;

import com.fet.edufet.dto.StaffDto;
import com.fet.edufet.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StaffController {

    private StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping("/staff")
    public ResponseEntity<List<StaffDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffDto> getOne(@PathVariable Integer id) {
        return new ResponseEntity<>(service.findOne(id),HttpStatus.OK);
    }

    @PostMapping("/staff")
    public ResponseEntity<StaffDto> saveOne(@RequestBody StaffDto staffDto) {
        return new ResponseEntity<>(service.save(staffDto),HttpStatus.CREATED);
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody StaffDto staffDto) {
        service.edit(id,staffDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
        service.delOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
