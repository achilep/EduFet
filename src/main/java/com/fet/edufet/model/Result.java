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
    @Column(name = "resultno")
    @Size(min=5, max=5,message ="RESULTNO must be 5")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RESULTNO;

    @Column(name = "subject_name")
    @Size(min=15, max=15,message ="SUBJECT_NAME must be 5")
    private String SUBJECT_NAME;

    @Column(name = "max_marks")
    @Size(min=5, max=5,message ="MAX_MARKS must be 5")
    private Integer MAX_MARKS;

    @Column(name = "pass_marks")
    @Size(min=3, max=3,message ="PASS_MARKS must be 5")
    private Integer PASS_MARKS;

    @Column(name = "marks_obt")
    @Size(min=3, max=3,message ="MARKS_OBT must be 3")
    private Integer MARKS_OBT;

    @Column(name = "result")
    @Size(min=4, max=4,message ="RESULT must be 5")
    private String RESULT;

    @ManyToOne
    private Student student;

}
