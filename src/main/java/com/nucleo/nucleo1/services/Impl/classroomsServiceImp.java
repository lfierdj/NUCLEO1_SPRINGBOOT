package com.nucleo.nucleo1.services.Impl;
import com.nucleo.nucleo1.entities.classrooms;
import com.nucleo.nucleo1.repositories.classroomsRepository;
import com.nucleo.nucleo1.services.classroomsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classroomsServiceImp implements classroomsService {

    @Autowired
    private classroomsRepository classroomsRepository;

    @Override
    public List<classrooms> getAllClassrooms() {
        return classroomsRepository.findAll();
    }

    @Override
    public List<classrooms> getAllCourses() {
        return List.of();
    }

    @Override
    public classrooms getClassroomById(Integer id) {
        return classroomsRepository.findById(id).orElse(null);
    }

    @Override
    public classrooms saveOrUpdateClassroom(classrooms classroom) {
        return classroomsRepository.save(classroom);
    }

    @Override
    public boolean deleteClassroom(Integer id) {
        if (classroomsRepository.existsById(id)) {
            classroomsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
