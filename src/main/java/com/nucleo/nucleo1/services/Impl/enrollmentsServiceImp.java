package com.nucleo.nucleo1.services.Impl;

import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.entities.students;
import com.nucleo.nucleo1.entities.enrollments;
import com.nucleo.nucleo1.repositories.enrollmentsRepository;
import com.nucleo.nucleo1.services.enrollmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class enrollmentsServiceImp implements enrollmentsService {
    @Autowired
    private enrollmentsRepository enrollmentsRepository;

    @Override
    public List<enrollments> getAllEnrollments() {
        return enrollmentsRepository.findAll();
    }

    @Override
    public List<courses> getAllCourses() {
        return List.of();
    }

    @Override
    public List<students> getAllStudents() {
        return List.of();
    }

    @Override
    public enrollments getEnrollmentById(Integer id) {
        return enrollmentsRepository.findById(id).orElse(null);
    }

    @Override
    public enrollments saveOrUpdateEnrollment(enrollments enrollment) {
        return enrollmentsRepository.save(enrollment);
    }

    @Override
    public boolean deleteEnrollment(Integer id) {
        if (enrollmentsRepository.existsById(id)) {
            enrollmentsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
