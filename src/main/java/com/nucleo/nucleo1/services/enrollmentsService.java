package com.nucleo.nucleo1.services;

import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.entities.students;
import com.nucleo.nucleo1.entities.enrollments;

import java.util.List;
public interface enrollmentsService {
    List<enrollments> getAllEnrollments();
    List<courses> getAllCourses();
    List<students> getAllStudents();
    enrollments getEnrollmentById(Integer id);
    enrollments saveOrUpdateEnrollment(enrollments enrollment);
    boolean deleteEnrollment(Integer id);
}
