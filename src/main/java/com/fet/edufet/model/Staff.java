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
    @Column(name = "empno", length = 5, nullable = false)
    private Integer EMPNO;

    @Column(name = "empname",length = 30)
    private String EMPNAME;

    @Column(name = "address",length = 30)
    private String ADDRESS;

    @Column(name = "city",length = 15)
    private String CITY;

    @Column(name = "pin",length = 6)
    private String PIN;

    @Column(name = "state",length = 15)
    private String STATE;

    @Column(name = "phone",length = 15)
    private String PHONE;

    @Column(name = "mobile",length = 13)
    private String MOBILE;

    @Column(name = "email",length = 30)
    private String EMAIL;

    @Column(name = "sex",length = 1)
    private String SEX;

    @Column(name = "M_STATUS",length = 15)
    private String M_STATUS;

    @Column(name = "dob")
    private LocalDate DOB;

    @Column(name = "doj")
    private LocalDate DOJ;

    @Column(name = "dept",length = 30)
    private String DEPT;

    @Column(name = "nature_of_job",length = 10)
    private String NATURE_OF_JOB;

    @Column(name = "basic_pay")
    private BigDecimal BASIC_PAY;
}
