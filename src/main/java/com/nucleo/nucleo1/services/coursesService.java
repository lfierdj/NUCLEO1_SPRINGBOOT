package com.nucleo.nucleo1.services;

import com.nucleo.nucleo1.entities.courses;

import java.util.List;
public interface coursesService {
    List<courses> getAllCourses();
    courses getCourseById(Integer id);
    courses saveOrUpdateCourse(courses course);
    boolean deleteCourse(Integer id);
}
