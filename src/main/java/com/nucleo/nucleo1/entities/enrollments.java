package com.nucleo.nucleo1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_enrollments")

public class enrollments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_enrollment;
    private String enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private students students;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private courses courses;
}
