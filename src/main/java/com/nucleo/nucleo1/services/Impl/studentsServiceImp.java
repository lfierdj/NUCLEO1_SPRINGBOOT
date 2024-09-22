package com.nucleo.nucleo1.services.Impl;

import com.nucleo.nucleo1.entities.students;
import com.nucleo.nucleo1.repositories.studentsRepository;
import com.nucleo.nucleo1.services.studentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class studentsServiceImp implements studentsService {
    @Autowired
    private studentsRepository studentsRepository;

    @Override
    public List<students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public students getStudentById(Integer id) {
        return studentsRepository.findById(id).orElse(null);
    }

    @Override
    public students saveOrUpdateStudent(students student) {
        return studentsRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        if (studentsRepository.existsById(id)) {
            studentsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
