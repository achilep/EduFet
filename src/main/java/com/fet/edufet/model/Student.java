package com.fet.edufet.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regno",length = 5, nullable = false)
    private Integer REGNO;

    @Column(name = "rollno",length = 5)
    private Integer ROLLNO;

    @Column(name = "class",length = 4)
    private String CLASS;

    @Column(name = "name",length = 25)
    private String NAME;

    @Column(name = "fname",length = 25)
    private String FNAME;

    @Column(name = "mname",length = 25)
    private String MNAME;

    @Column(name = "dob")
    private LocalDate DOB;

    @Column(name = "dor")
    private LocalDate DOR;

    @Column(name = "address",length = 30)
    private String ADDRESS;

    @Column(name = "city",length = 15)
    private String CITY;

    @Column(name = "pin",length = 6)
    private String PIN;

    @Column(name = "phone",length = 15)
    private String PHONE;


}
