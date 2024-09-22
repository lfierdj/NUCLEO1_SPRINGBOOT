package com.nucleo.nucleo1.services;

import com.nucleo.nucleo1.entities.students;

import java.util.List;
public interface studentsService {
    List<students> getAllStudents();
    students getStudentById(Integer id);
    students saveOrUpdateStudent(students student);
    boolean deleteStudent(Integer id);
}
