package com.nucleo.nucleo1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_teachers")

public class teachers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_teacher;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private classrooms classrooms;
}
