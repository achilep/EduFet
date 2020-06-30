package com.fet.edufet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private Integer REGNO;
    private Integer ROLLNO;
    private String CLASS;
    private String FNAME;
    private String MNAME;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOR;
    private String ADDRESS;
    private String CITY;
    private String PIN;
    private String PHONE;
}
