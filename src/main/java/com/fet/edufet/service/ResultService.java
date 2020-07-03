package com.fet.edufet.service;

import com.fet.edufet.dto.NewResultDto;
import com.fet.edufet.dto.ResultDto;
import com.fet.edufet.exception.UserNotFound;
import com.fet.edufet.model.Result;
import com.fet.edufet.model.Student;
import com.fet.edufet.repository.ResultRepository;
import com.fet.edufet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    private ResultRepository repository;

    private StudentRepository studentRepository;


    public ResultService(ResultRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    public ResultDto copyResultToResultDto(Result result,ResultDto resultDto) {
        resultDto.setRESULTNO(result.getRESULTNO());
        resultDto.setMARKS_OBT(result.getMARKS_OBT());
        resultDto.setRESULT(result.getRESULT());
        resultDto.setMAX_MARKS(result.getMAX_MARKS());
        resultDto.setPASS_MARKS(result.getMAX_MARKS());
        resultDto.setSUBJECT_NAME(result.getSUBJECT_NAME());
        resultDto.setREGNO(result.getStudent().getREGNO());
        return resultDto;
    }

    public Result copyNewResultDtoToResult(NewResultDto resultDto, Result result , Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            result.setRESULTNO(resultDto.getRESULTNO());
            result.setMARKS_OBT(resultDto.getMARKS_OBT());
            result.setRESULT(resultDto.getRESULT());
            result.setMAX_MARKS(resultDto.getMAX_MARKS());
            result.setPASS_MARKS(resultDto.getMAX_MARKS());
            result.setSUBJECT_NAME(resultDto.getSUBJECT_NAME());
            result.setStudent(student);
            return result;
        }
        throw new UserNotFound("Student id "+ id+ " doesnt exist");
    }


    public List<ResultDto> getOne(Integer studentId) {
        Iterable<Result> results = repository.findAllByStudent_REGNO(studentId);
        List<ResultDto> resultDtos = new ArrayList<>();
        for(Result result: results) {
            resultDtos.add(copyResultToResultDto(result,new ResultDto()));
        }
        return resultDtos;
    }

    public ResultDto saveOne(Integer studentId, NewResultDto dto) {
        Result  result = repository.save(copyNewResultDtoToResult(dto,new Result(),studentId));
        return copyResultToResultDto(result,new ResultDto());
    }


    public void edit(Integer resultId, Integer studentId, NewResultDto dto) {
        Optional<Result> optional = repository.findById(resultId);
        if(optional.isPresent()) {
            Result result = optional.get();
            result= copyNewResultDtoToResult(dto,result,studentId);
            result.setRESULTNO(resultId);
            repository.save(result);
        }
        throw new UserNotFound("Result id "+ resultId+ " doesnt exist");
    }

    public void delOne(Integer resultId) {
        repository.deleteById(resultId);
    }

}
