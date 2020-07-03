package com.fet.edufet.service;

import com.fet.edufet.dto.StudentDto;
import com.fet.edufet.exception.UserNotFound;
import com.fet.edufet.model.Student;
import com.fet.edufet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDto> getAll() {
        Iterable<Student> iterable = repository.findAll();
        List<StudentDto> dtos = new ArrayList<>();
        for (Student student: iterable) {
            StudentDto dto = new StudentDto();
            dto.setREGNO(student.getREGNO());
            dto.setROLLNO(student.getROLLNO());
            dto.setNAME(student.getNAME());
            dto.setFNAME(student.getFNAME());
            dto.setMNAME(student.getMNAME());
            dto.setADDRESS(student.getADDRESS());
            dto.setCITY(student.getCITY());
            dto.setDOB(student.getDOB());
            dto.setDOR(student.getDOR());
            dto.setPHONE(student.getPHONE());
            dto.setPIN(student.getPIN());
            dto.setCLASS(student.getCLASS());
            dtos.add(dto);
        }
        return dtos;
    }

    public StudentDto getOne(Integer id) {
        Optional<Student> studentOptional = repository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentDto dto = new StudentDto();
            dto.setREGNO(student.getREGNO());
            dto.setROLLNO(student.getROLLNO());
            dto.setNAME(student.getNAME());
            dto.setFNAME(student.getFNAME());
            dto.setMNAME(student.getMNAME());
            dto.setADDRESS(student.getADDRESS());
            dto.setCITY(student.getCITY());
            dto.setDOB(student.getDOB());
            dto.setDOR(student.getDOR());
            dto.setPHONE(student.getPHONE());
            dto.setPIN(student.getPIN());
            dto.setCLASS(student.getCLASS());
            return dto;
        }
        throw new UserNotFound("Student id "+ id+ " doesnt exist");
    }

    public StudentDto save(StudentDto studentDto) {
        Student student = new Student();
        student.setREGNO(studentDto.getREGNO());
        student.setROLLNO(studentDto.getROLLNO());
        student.setADDRESS(studentDto.getADDRESS());
        student.setCITY(studentDto.getCITY());
        student.setCLASS(studentDto.getCLASS());
        student.setDOB(studentDto.getDOB());
        student.setDOR(LocalDate.now());
        student.setFNAME(studentDto.getFNAME());
        student.setMNAME(studentDto.getMNAME());
        student.setNAME(studentDto.getNAME());
        student.setPHONE(studentDto.getPHONE());
        student.setPIN(studentDto.getPIN());
        student = repository.save(student);
        return studentDto;
    }

    public void deleteOne(Integer id) {
       repository.deleteById(id);
    }

    public void update(Integer id, StudentDto studentDto) {
        Optional<Student> studentOptional = repository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setREGNO(studentDto.getREGNO());
            student.setROLLNO(studentDto.getROLLNO());
            student.setADDRESS(studentDto.getADDRESS());
            student.setCITY(studentDto.getCITY());
            student.setCLASS(studentDto.getCLASS());
            student.setDOB(studentDto.getDOB());
            student.setDOR(studentDto.getDOR());
            student.setFNAME(studentDto.getFNAME());
            student.setMNAME(studentDto.getMNAME());
            student.setNAME(studentDto.getNAME());
            student.setPHONE(studentDto.getPHONE());
            student.setPIN(studentDto.getPIN());
            student = repository.save(student);
        }
    }
}
