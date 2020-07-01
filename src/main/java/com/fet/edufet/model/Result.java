package com.fet.edufet.model;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "result_tbl")
public class Result {

    @Id
    @Column(name = "resultno",length = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RESULTNO;

    @Column(name = "subject_name",length = 15)
    private String SUBJECT_NAME;

    @Column(name = "max_marks",length = 5)
    private Integer MAX_MARKS;

    @Column(name = "pass_marks",length = 3)
    private Integer PASS_MARKS;

    @Column(name = "marks_obt",length = 3)
    private Integer MARKS_OBT;

    @Column(name = "result",length = 4)
    private String RESULT;

    @ManyToOne
    private Student student;

}
