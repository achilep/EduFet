package com.fet.edufet.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "fee_tbl")
public class Fee {

    @Id
    @Column(name = "feeno")
    @Size(min=5, max=5,message ="FEENO must be 5")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FEENO;

    @Column(name = "feedep")
    @Size(min=5, max=5,message ="FEEDEP must be 5")
    private Integer FEEDEP;

    @Column(name = "depdate")
    private LocalDate DEPDATE;

    @Column(name = "fine")
    @Size(min=3, max=3,message ="FINE must be 5")
    private Integer FINE;

    @ManyToOne
    private Student student;


}
