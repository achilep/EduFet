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
    @Column(name = "regno", nullable = false)
    @Size(min=5, max=5,message ="REGNO must be 5")
    private Integer REGNO;

    @Column(name = "rollno")
    @Size(min=5, max=5,message ="ROLLNO must be 5")
    private Integer ROLLNO;

    @Column(name = "class")
    @Size(min=4, max=4,message ="CLASS must be 4")
    private String CLASS;

    @Column(name = "name")
    @Size(min=25, max=25,message ="NAME must be 25")
    private String NAME;

    @Column(name = "fname")
    @Size(min=25, max=25,message ="FNAME must be 30")
    private String FNAME;

    @Column(name = "mname")
    @Size(min=25, max=25,message ="MNAME must be 30")
    private String MNAME;

    @Column(name = "dob")
    private LocalDate DOB;

    @Column(name = "dor")
    private LocalDate DOR;

    @Column(name = "address")
    @Size(min=30, max=30,message ="ADDRESS must be 30")
    private String ADDRESS;

    @Column(name = "city")
    @Size(min=15, max=15,message ="CITY must be 15")
    private String CITY;

    @Column(name = "pin")
    @Size(min=6, max=6,message ="PIN must be 6")
    private String PIN;

    @Column(name = "phone")
    @Size(min=15, max=15,message ="PHONE must be 15")
    private String PHONE;


}
