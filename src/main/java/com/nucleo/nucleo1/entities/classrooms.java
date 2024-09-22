package com.nucleo.nucleo1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_classrooms")
public class classrooms implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;
    private String number;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private courses courses;
}
