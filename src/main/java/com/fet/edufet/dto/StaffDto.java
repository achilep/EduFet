package com.fet.edufet.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StaffDto {
    private Integer EMPNO;
    private String EMPNAME;
    private String ADDRESS;
    private String CITY;
    private String PIN;
    private String STATE;
    private String PHONE;
    private String MOBILE;
    private String EMAIL;
    private String SEX;
    private String M_STATUS;
    private LocalDate DOB;
    private LocalDate DOJ;
    private String DEPT;
    private String NATURE_OF_JOB;
    private BigDecimal BASIC_PAY;

}
