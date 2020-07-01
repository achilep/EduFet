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
    @Column(name = "feeno",length = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FEENO;

    @Column(name = "feedep",length = 5)
    private Integer FEEDEP;

    @Column(name = "depdate")
    private LocalDate DEPDATE;

    @Column(name = "fine",length = 3)
    private Integer FINE;

    @ManyToOne
    private Student student;


}
