package com.fet.edufet.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "staff_tbl")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno", nullable = false)
    @Size(min=5, max=5,message ="EMPNO must be 5")
    private Integer EMPNO;

    @Column(name = "empname")
    @Size(min=30, max=30,message ="EMPNANE must be 30")
    private String EMPNAME;

    @Column(name = "address")
    @Size(min=30, max=30,message ="ADDRESS must be 30")
    private String ADDRESS;

    @Column(name = "city")
    @Size(min=15, max=15,message ="CITY must be 15")
    private String CITY;

    @Column(name = "pin")
    @Size(min=6, max=6,message ="PIN must be 6")
    private String PIN;

    @Column(name = "state")
    @Size(min=15, max=15,message ="STATE must be 15")
    private String STATE;

    @Column(name = "phone")
    @Size(min=15, max=15,message ="PHONE must be 15")
    private String PHONE;

    @Column(name = "mobile")
    @Size(min=13, max=13,message ="MOBILE must be 13")
    private String MOBILE;

    @Column(name = "email")
    @Size(min=30, max=30,message ="EMAIL must be 30")
    private String EMAIL;

    @Column(name = "sex")
    @Size(min=1, max=1,message ="SEX must be 1")
    private String SEX;

    @Column(name = "M_STATUS")
    @Size(min=15, max=15,message ="M_STATUS must be 15")
    private String M_STATUS;

    @Column(name = "dob")
    private LocalDate DOB;

    @Column(name = "doj")
    private LocalDate DOJ;

    @Column(name = "dept")
    @Size(min=30, max=30,message ="DEPT must be 30")
    private String DEPT;

    @Column(name = "nature_of_job")
    @Size(min=10, max=10,message ="NATURE_OF_JOB must be 10")
    private String NATURE_OF_JOB;

    @Column(name = "basic_pay")
    private BigDecimal BASIC_PAY;
}
