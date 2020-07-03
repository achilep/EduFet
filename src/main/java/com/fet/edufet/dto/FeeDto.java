package com.fet.edufet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FeeDto {
    private Integer FEENO;
    private Integer REGNO;
    private Integer ROLLNO;
    private String CLASS;
    private Integer FEEDEP;
    private LocalDate DEPDATE;
    private Integer FINE;
}
