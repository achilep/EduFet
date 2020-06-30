package com.fet.edufet.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @Column(name = "user_id")
    @Size(min=5, max=5,message ="USER_ID must be 5")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer USER_ID;

    @NotNull
    @Column(name = "username",length = 15)
    private String USERNAME;

    @NotNull
    @Column(name = "password", length = 15)
    private String PASSWORD;

}
