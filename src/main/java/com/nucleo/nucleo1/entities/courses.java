package com.nucleo.nucleo1.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_courses")
public class courses implements Serializable{
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_course;
    private String name;
    private String description;
    private int credits;
}
