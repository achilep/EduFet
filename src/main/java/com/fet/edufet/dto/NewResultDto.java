package com.fet.edufet.dto;

import lombok.Data;

@Data
public class NewResultDto {
    private Integer RESULTNO;
    private String SUBJECT_NAME;
    private Integer MAX_MARKS;
    private Integer PASS_MARKS;
    private Integer MARKS_OBT;
    private String RESULT;
}
