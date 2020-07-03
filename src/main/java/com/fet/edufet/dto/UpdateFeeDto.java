package com.fet.edufet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateFeeDto {
    private Integer FEENO;
    private Integer FEEDEP;
    private LocalDate DEPDATE;
    private Integer FINE;
}
