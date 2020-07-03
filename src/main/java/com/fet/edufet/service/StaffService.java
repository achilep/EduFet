package com.fet.edufet.service;

import com.fet.edufet.dto.StaffDto;
import com.fet.edufet.exception.UserNotFound;
import com.fet.edufet.model.Staff;
import com.fet.edufet.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }


    public StaffDto copyStaffToStaffDto(Staff staff , StaffDto staffDto) {
        staffDto.setEMPNO(staff.getEMPNO());
        staffDto.setEMPNAME(staff.getEMPNAME());
        staffDto.setADDRESS(staff.getADDRESS());
        staffDto.setBASIC_PAY(staff.getBASIC_PAY());
        staffDto.setCITY(staff.getCITY());
        staffDto.setDEPT(staff.getDEPT());
        staffDto.setDOB(staff.getDOB());
        staffDto.setDOJ(staff.getDOJ());
        staffDto.setM_STATUS(staff.getM_STATUS());
        staffDto.setEMAIL(staff.getEMAIL());
        staffDto.setMOBILE(staff.getMOBILE());
        staffDto.setSTATE(staff.getSTATE());
        staffDto.setPHONE(staff.getPHONE());
        staffDto.setNATURE_OF_JOB(staff.getNATURE_OF_JOB());
        staffDto.setSEX(staff.getSEX());
        staffDto.setSTATE(staff.getSTATE());
        staffDto.setPIN(staff.getPIN());
        return staffDto;
    }
    public Staff copyStaffDtoToStaff(StaffDto staffDto, Staff staff) {
        staff.setEMPNO(staffDto.getEMPNO());
        staff.setEMPNAME(staffDto.getEMPNAME());
        staff.setADDRESS(staffDto.getADDRESS());
        staff.setBASIC_PAY(staffDto.getBASIC_PAY());
        staff.setCITY(staffDto.getCITY());
        staff.setDEPT(staffDto.getDEPT());
        staff.setDOB(staffDto.getDOB());
        staff.setDOJ(staffDto.getDOJ());
        staff.setM_STATUS(staffDto.getM_STATUS());
        staff.setEMAIL(staffDto.getEMAIL());
        staff.setMOBILE(staffDto.getMOBILE());
        staff.setSTATE(staffDto.getSTATE());
        staff.setPHONE(staffDto.getPHONE());
        staff.setNATURE_OF_JOB(staffDto.getNATURE_OF_JOB());
        staff.setSEX(staffDto.getSEX());
        staff.setSTATE(staffDto.getSTATE());
        staff.setPIN(staffDto.getPIN());
        return staff;

    }

    public List<StaffDto> getAll() {
        Iterable<Staff> staffs = repository.findAll();
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Staff staff: staffs) {
            StaffDto staffDto = new StaffDto();
            staffDtos.add(copyStaffToStaffDto(staff,staffDto));
        }
        return staffDtos;
    }

    public StaffDto findOne(Integer id) {
        Optional<Staff> staffOptional = repository.findById(id);
        if (staffOptional.isPresent()) {
            Staff staff = staffOptional.get();
            StaffDto staffDto = new StaffDto();
            staffDto = copyStaffToStaffDto(staff,staffDto);
            return staffDto;
        }
        throw new UserNotFound("Staff id "+ id+ " doesnt exist");
    }

    public StaffDto save(StaffDto staffDto) {
        Staff staff = new Staff();
        staff = copyStaffDtoToStaff(staffDto,staff);
        repository.save(staff);
        return staffDto;
    }

    public void edit(Integer id, StaffDto staffDto) {
        Optional<Staff> staffOptional = repository.findById(id);
        if (staffOptional.isPresent()) {
            Staff staff = staffOptional.get();
            staff = copyStaffDtoToStaff(staffDto, staff);
            repository.save(staff);
        }
        throw new UserNotFound("Staff id "+ id+ " doesnt exist");
    }

    public void delOne(Integer id) {
        repository.deleteById(id);
    }
}
