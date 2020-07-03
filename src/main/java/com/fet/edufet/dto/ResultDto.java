package com.fet.edufet.dto;

import lombok.Data;

@Data
public class ResultDto {
    private Integer RESULTNO;
    private Integer REGNO;
    private String SUBJECT_NAME;
    private Integer MAX_MARKS;
    private Integer PASS_MARKS;
    private Integer MARKS_OBT;
    private String RESULT;
}
