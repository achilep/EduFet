package com.fet.edufet.service;

import com.fet.edufet.dto.FeeDto;
import com.fet.edufet.dto.UpdateFeeDto;
import com.fet.edufet.exception.UserNotFound;
import com.fet.edufet.model.Fee;
import com.fet.edufet.model.Student;
import com.fet.edufet.repository.FeeRepository;
import com.fet.edufet.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeeService {
    private FeeRepository repository;
    private StudentRepository studentRepository;

    public FeeService(FeeRepository repository,StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    public FeeDto copyFeeToFeeDto(Fee fee, FeeDto feeDto) {
        feeDto.setFEENO(fee.getFEENO());
        feeDto.setFEEDEP(fee.getFEEDEP());
        feeDto.setFINE(fee.getFINE());
        feeDto.setDEPDATE(fee.getDEPDATE());
        feeDto.setCLASS(fee.getStudent().getCLASS());
        feeDto.setREGNO(fee.getStudent().getREGNO());
        feeDto.setROLLNO(fee.getStudent().getROLLNO());
        return feeDto;
    }

    public Fee copyUpdateFeeDtoToFee(UpdateFeeDto feeDto, Fee fee, Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            fee.setFEENO(feeDto.getFEENO());
            fee.setFEEDEP(feeDto.getFEEDEP());
            fee.setFINE(feeDto.getFINE());
            fee.setDEPDATE(feeDto.getDEPDATE());
            fee.setStudent(student);
            return fee;
        }
        throw new UserNotFound("Student id "+ id+ " doesnt exist");
    }

    public List<FeeDto> getAll() {
        Iterable<Fee> fees = repository.findAll();
        List<FeeDto> feeDtos = new ArrayList<>();

        for(Fee fee: fees) {
            FeeDto feeDto = new FeeDto();
            feeDtos.add(copyFeeToFeeDto(fee,feeDto));
        }
        return feeDtos;
    }

    public FeeDto getOne(Integer studentId) {
        Optional<Fee> optionalFee = repository.findFeeByStudent_REGNO(studentId);
        if (optionalFee.isPresent()){
            return copyFeeToFeeDto(optionalFee.get(),new FeeDto());
        }
        throw new UserNotFound("Student id "+ studentId+ " fees doesnt exist");
    }

    public FeeDto saveOne(Integer studentId, UpdateFeeDto dto) {
        Fee fee= repository.save(copyUpdateFeeDtoToFee(dto,new Fee(),studentId));
        return copyFeeToFeeDto(fee,new FeeDto());
    }

    public void editOne(Integer id, UpdateFeeDto dto) {
        Optional<Fee> feeOptional = repository.findFeeByStudent_REGNO(id);
        if (feeOptional.isPresent()) {
            repository.save(copyUpdateFeeDtoToFee(dto, new Fee(), id));
        }
        throw new UserNotFound("Student id "+ id+ " fees doesnt exist");
    }

    public void delOne(Integer studentId) {
        repository.deleteById(repository.findFeeByStudent_REGNO(studentId).get().getFEENO());
    }
}
