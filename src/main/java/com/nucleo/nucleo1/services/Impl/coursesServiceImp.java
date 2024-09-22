package com.nucleo.nucleo1.services.Impl;

import com.nucleo.nucleo1.entities.courses;
import com.nucleo.nucleo1.repositories.coursesRepository;
import com.nucleo.nucleo1.services.coursesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class coursesServiceImp implements coursesService {
    @Autowired
    private coursesRepository coursesRepository;

    @Override
    public List<courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public courses getCourseById(Integer id) {
        return coursesRepository.findById(id).orElse(null);
    }

    @Override
    public courses saveOrUpdateCourse(courses course) {
        return coursesRepository.save(course);
    }

    @Override
    public boolean deleteCourse(Integer id) {
        if (coursesRepository.existsById(id)) {
            coursesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
