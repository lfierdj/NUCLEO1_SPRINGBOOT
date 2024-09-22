package com.nucleo.nucleo1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_students")

public class students implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_student;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String birthDate;
}
