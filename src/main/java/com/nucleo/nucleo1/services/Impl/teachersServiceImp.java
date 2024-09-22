package com.nucleo.nucleo1.services.Impl;

import com.nucleo.nucleo1.entities.classrooms;
import com.nucleo.nucleo1.entities.teachers;
import com.nucleo.nucleo1.repositories.teachersRepository;
import com.nucleo.nucleo1.services.teachersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teachersServiceImp implements teachersService {
    @Autowired
    private teachersRepository teachersRepository;

    @Override
    public List<teachers> getAllTeachers() {
        return teachersRepository.findAll();
    }

    @Override
    public List<classrooms> getAllClassrooms() {
        return List.of();
    }

    @Override
    public teachers getTeacherById(Integer id) {
        return teachersRepository.findById(id).orElse(null);
    }

    @Override
    public teachers saveOrUpdateTeacher(teachers teacher) {
        return teachersRepository.save(teacher);
    }

    @Override
    public boolean deleteTeacher(Integer id) {
        if (teachersRepository.existsById(id)) {
            teachersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
